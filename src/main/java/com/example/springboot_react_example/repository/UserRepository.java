package com.example.springboot_react_example.repository;

import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Member,Long> {

    @Query(value = "select u from Member u")
    Page<UserResponse> userList(Pageable pageable);
    Optional<Member> findByUserId(String userId);
    boolean existsByUseremail(String email);
    boolean existsByUserId(String userId);
}
