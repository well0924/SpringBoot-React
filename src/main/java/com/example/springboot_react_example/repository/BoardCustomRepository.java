package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.Const.SearchType;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardCustomRepository {

    //게시글 목록 (페이징)
    Page<BoardResponse>boardListAll(Pageable pageable);
    //게시글 검색
    Page<BoardResponse>boardListSearch(Pageable pageable, SearchType searchType, String searchVal);
    //게시글 상세조회
    Optional<BoardResponse>boardDetail(Long boardId);
}
