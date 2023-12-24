package com.example.springboot_react_example.domain.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String contents;
}
