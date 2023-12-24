package com.example.springboot_react_example.domain.Const;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchType {
    TITLE("title"),
    CONTENTS("content"),
    AUTHOR("created_by");
    private final String value;
}
