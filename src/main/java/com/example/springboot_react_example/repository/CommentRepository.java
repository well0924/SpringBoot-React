package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long>,CommentCustomRepository {
}
