package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.QBoardEntity;
import com.example.springboot_react_example.domain.QComment;
import com.example.springboot_react_example.domain.QMember;
import com.example.springboot_react_example.domain.dto.CommentResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class CommentCustomRepositoryImpl implements CommentCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    QMember qMember;
    QBoardEntity qBoardEntity;
    QComment qComment;

    public CommentCustomRepositoryImpl(EntityManager entityManager){
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.qMember = QMember.member;
        this.qBoardEntity = QBoardEntity.boardEntity;
        this.qComment = QComment.comment;
    }

    @Override
    public List<CommentResponse> commentList(Long boardId) {
        JPQLQuery<CommentResponse>commentList = jpaQueryFactory
                .select(Projections.constructor(CommentResponse.class,qComment))
                .from(qComment)
                .where(qComment.board.idx.eq(boardId));
        return commentList.stream().toList();
    }
}
