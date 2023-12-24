package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.Const.UserRole;
import com.example.springboot_react_example.domain.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String userId;
    private String username;
    private String useremail;
    private UserRole userRole;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdTime;

    @Builder
    public UserResponse(Member member){
        this.id = member.getId();
        this.userId = member.getUserId();
        this.username = member.getUsername();
        this.useremail = member.getUseremail();
        this.userRole = member.getUserRole();
        this.createdTime = member.getCreatedTime();
    }

    public static UserResponse response(Member member){
       return UserResponse.builder()
               .id(member.getId())
               .userId(member.getUserId())
               .username(member.getUsername())
               .useremail(member.getUseremail())
               .userRole(UserRole.ROLE_USER)
               .createdTime(LocalDateTime.now())
               .build();
    }
}
