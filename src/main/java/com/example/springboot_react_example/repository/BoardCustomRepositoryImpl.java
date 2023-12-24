package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.QBoardEntity;
import com.example.springboot_react_example.domain.QMember;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QMember qMember;
    QBoardEntity qBoardEntity;

    public BoardCustomRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
        qMember = QMember.member;
        qBoardEntity = QBoardEntity.boardEntity;
    }

    //게시글 목록(페이징)
    @Override
    public Page<BoardResponse> boardListAll(Pageable pageable) {
        return null;
    }
}
