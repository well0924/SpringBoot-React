package com.example.springboot_react_example.domain;

import com.example.springboot_react_example.domain.Const.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "TB_USER")
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String userId;
    @Setter
    private String password;
    @Setter
    private String username;
    @Setter
    private String useremail;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdTime;

    @Builder
    public Member(Long id,String userId, String password, String username, String useremail, UserRole userRole, LocalDateTime createdTime){
        this.id =id;
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.useremail = useremail;
        this.userRole = userRole;
        this.createdTime = createdTime;
    }
}
