package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.BoardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private Long idx;
    private String title;
    private String contents;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    //댓글
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentResponse>commentResponseList = new ArrayList<>();
    //파일목록
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FileResponse>fileResponseList = new ArrayList<>();

    @Builder
    @QueryProjection
    public BoardResponse(BoardEntity board){
        this.idx = board.getIdx();
        this.title  = board.getTitle();
        this.contents = board.getContents();
        this.createdBy = board.getCreatedBy();
        this.createdAt = board.getCreatedAt();
        this.commentResponseList = board
                .getCommentList()!=null ?
                board.getCommentList().stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList())
                : Collections.emptyList();
        this.fileResponseList = board.getFileEntityList() != null ? board
                .getFileEntityList()
                .stream().map(fileEntity -> new FileResponse(fileEntity)).collect(Collectors.toList())
                : Collections.emptyList();
    }
}
