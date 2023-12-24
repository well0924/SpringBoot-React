package com.example.springboot_react_example.controller;

import com.example.springboot_react_example.config.security.AuthService;
import com.example.springboot_react_example.domain.dto.TokenDto;
import com.example.springboot_react_example.domain.dto.UserRequest;
import com.example.springboot_react_example.domain.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody UserRequest requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserRequest requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }
}
