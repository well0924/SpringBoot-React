package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.dto.BoardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardCustomRepository {

    //게시글 목록 (페이징)
    Page<BoardResponse>boardListAll(Pageable pageable);
    //게시글 검색

}
