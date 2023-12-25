package com.example.springboot_react_example.domain.Const;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SearchType {
    TITLE,
    CONTENTS,
    AUTHOR,
    ALL;

    public static SearchType toSearch(String searchType){
        return switch (searchType){
            case "title"->TITLE;
            case "created_by"->AUTHOR;
            case "content"->CONTENTS;
            default -> ALL;
        };
    }
}
