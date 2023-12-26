package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.Const.SearchType;
import com.example.springboot_react_example.domain.QBoardEntity;
import com.example.springboot_react_example.domain.QMember;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.function.Supplier;

import static com.example.springboot_react_example.domain.Const.SearchType.*;

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

        JPQLQuery<BoardResponse>boardResponseJPQLQuery = jpaQueryFactory
                .select(Projections.constructor(BoardResponse.class,qBoardEntity))
                .from(qBoardEntity)
                .orderBy(qBoardEntity.idx.desc())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset());

        return PageableExecutionUtils.getPage(boardResponseJPQLQuery.fetch(),pageable,boardResponseJPQLQuery::fetchCount);
    }

    //게시글 검색(작성자, 내용, 제목)
    @Override
    public Page<BoardResponse> boardListSearch(Pageable pageable, SearchType searchType, String searchVal) {

        JPQLQuery<BoardResponse>boardResponseJPQLQuery = jpaQueryFactory
                .select(Projections.constructor(BoardResponse.class,qBoardEntity))
                .from(qBoardEntity)
                .orderBy(qBoardEntity.idx.desc());

        JPQLQuery<BoardResponse>middleQuery;

        switch (searchType){
            case AUTHOR :
               middleQuery = boardResponseJPQLQuery.where(authorCt(searchVal)); break;
            case TITLE:
               middleQuery =  boardResponseJPQLQuery.where(titleCt(searchVal)); break;
            case CONTENTS:
               middleQuery = boardResponseJPQLQuery.where(contentsCt(searchVal)); break;
            default :
                middleQuery = boardResponseJPQLQuery.where(authorCt(searchVal).or(titleCt(searchVal).or(contentsCt(searchVal))));
        };

        return PageableExecutionUtils
                .getPage(middleQuery
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch(),pageable,middleQuery::fetchCount);
    }

    //게시글 작성자기준
    BooleanBuilder authorCt(String searchVal){return nullSafeBuilder(()->qBoardEntity.createdBy.contains(searchVal));}
    //게시글 내용 기준
    BooleanBuilder contentsCt(String searchVal){return nullSafeBuilder(()->qBoardEntity.contents.contains(searchVal));}
    //게시글 제목 기준
    BooleanBuilder titleCt(String searchVal) {return nullSafeBuilder(() -> qBoardEntity.title.contains(searchVal));}

    //BooleanBuilder를 Safe하게 만들기 위해 만든 메소드
    BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
}
