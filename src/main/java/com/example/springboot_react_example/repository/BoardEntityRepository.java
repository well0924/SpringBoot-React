package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BoardEntityRepository extends JpaRepository<BoardEntity,Long> {

    @Query(value = "select b from BoardEntity b")
    Page<BoardResponse> findAllList(Pageable pageable);

    @Query(value = "select count(b) from BoardEntity b")
    Integer boardCount();
}
