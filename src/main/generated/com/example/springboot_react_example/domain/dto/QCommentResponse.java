package com.example.springboot_react_example.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.springboot_react_example.domain.dto.QCommentResponse is a Querydsl Projection type for CommentResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCommentResponse extends ConstructorExpression<CommentResponse> {

    private static final long serialVersionUID = 1972717434L;

    public QCommentResponse(com.querydsl.core.types.Expression<? extends com.example.springboot_react_example.domain.Comment> comment) {
        super(CommentResponse.class, new Class<?>[]{com.example.springboot_react_example.domain.Comment.class}, comment);
    }

}

