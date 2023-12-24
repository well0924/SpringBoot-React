package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.Const.UserRole;
import com.example.springboot_react_example.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserRequest {
    private String userId;
    private String password;
    private String username;
    private String useremail;
    private UserRole userRole;

    public Member toEntity(PasswordEncoder encoder){
        return Member.builder()
                .userId(userId)
                .password(encoder.encode(password))
                .useremail(useremail)
                .username(username)
                .userRole(userRole.ROLE_USER)
                .createdTime(LocalDateTime.now())
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userId, password);
    }
}
