package com.example.springboot_react_example.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CommentRequest {
    private Long boardId;
    private String contents;
}
