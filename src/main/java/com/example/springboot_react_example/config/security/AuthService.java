package com.example.springboot_react_example.config.security;

import com.example.springboot_react_example.config.jwt.JwtProvider;
import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.TokenDto;
import com.example.springboot_react_example.domain.dto.UserRequest;
import com.example.springboot_react_example.domain.dto.UserResponse;
import com.example.springboot_react_example.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    //회원 가입
    @Transactional
    public UserResponse signup(UserRequest requestDto) {
        if (userRepository.existsByUseremail(requestDto.getUseremail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }
        Member member = requestDto.toEntity(passwordEncoder);
        return UserResponse.response(userRepository.save(member));
    }

    //로그인
    @Transactional
    public TokenDto login(UserRequest requestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(requestDto.getUserId(),requestDto.getPassword());

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.createToken(authentication.getName(),getAuthorities(authentication));
    }

    // 권한 이름 가져오기
    public String getAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}
