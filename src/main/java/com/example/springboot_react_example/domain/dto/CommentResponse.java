package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.Comment;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private String createdBy;
    private String contents;
    private LocalDateTime createdAt;

    @Builder
    @QueryProjection
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.createdBy = comment.getCreatedBy();
        this.contents = comment.getContents();
        this.createdAt = comment.getCreatedAt();
    }
}
