package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.dto.BoardRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;


public interface BoardEntityRepository extends JpaRepository<BoardEntity,Long>,BoardCustomRepository {

    @Modifying
    @Query(value = "update BoardEntity b set b.title = :title ,b.contents = :contents where b.idx = :id")
    void updatedBoard(@Param("id") Long id,@Param("title")String title,@Param("contents") String contents);
}
