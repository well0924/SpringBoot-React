package com.example.springboot_react_example.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.springboot_react_example.domain.dto.QBoardResponse is a Querydsl Projection type for BoardResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardResponse extends ConstructorExpression<BoardResponse> {

    private static final long serialVersionUID = 320567169L;

    public QBoardResponse(com.querydsl.core.types.Expression<? extends com.example.springboot_react_example.domain.BoardEntity> board) {
        super(BoardResponse.class, new Class<?>[]{com.example.springboot_react_example.domain.BoardEntity.class}, board);
    }

}

