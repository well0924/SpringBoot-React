package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardEntityRepository extends JpaRepository<BoardEntity,Long>,BoardCustomRepository {

}
