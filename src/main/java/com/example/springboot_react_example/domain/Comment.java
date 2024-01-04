package com.example.springboot_react_example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COMMENT")
@Getter
@ToString
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String contents;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "board_id",nullable = false,referencedColumnName = "board_id")
    private BoardEntity board;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_idx", referencedColumnName = "id")
    private Member member;


    @Builder
    public Comment(String contents,String createdBy,Member member,BoardEntity board,LocalDateTime createdAt){
        this.contents = contents;
        this.createdBy = createdBy;
        this.member = member;
        this.board = board;
        this.createdAt = createdAt;
    }
}
