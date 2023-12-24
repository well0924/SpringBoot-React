package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.BoardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
public class BoardResponse {
    private Long idx;
    private String title;
    private String contents;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @Builder
    public BoardResponse(BoardEntity board){
        this.idx = board.getIdx();
        this.title  = board.getTitle();
        this.contents = board.getContents();
        this.createdBy = board.getCreatedBy();
        this.createdAt = board.getCreatedAt();
    }
}
