package com.example.springboot_react_example.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.springboot_react_example.domain.dto.QUserResponse is a Querydsl Projection type for UserResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserResponse extends ConstructorExpression<UserResponse> {

    private static final long serialVersionUID = 606954418L;

    public QUserResponse(com.querydsl.core.types.Expression<? extends com.example.springboot_react_example.domain.Member> member) {
        super(UserResponse.class, new Class<?>[]{com.example.springboot_react_example.domain.Member.class}, member);
    }

}

