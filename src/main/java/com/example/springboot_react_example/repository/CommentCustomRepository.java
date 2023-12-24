package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.dto.CommentResponse;

import java.util.List;

public interface CommentCustomRepository {
    List<CommentResponse>commentList(Long boardId);
}
