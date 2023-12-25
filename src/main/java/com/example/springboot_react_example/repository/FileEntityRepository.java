package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity,Long> {
}
