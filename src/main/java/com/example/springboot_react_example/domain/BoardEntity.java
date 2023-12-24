package com.example.springboot_react_example.domain;

import com.example.springboot_react_example.domain.dto.BoardRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_BOARD")
@Getter
@ToString
@NoArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long idx;
    private String title;
    private String contents;
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Member member;

    @Builder
    public BoardEntity(String title, String contents, String createdBy, LocalDateTime createdAt, Member member){
        this.title = title;
        this.contents = contents;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.member = member;
    }

    public void boardUpdate(BoardRequest request){
        this.title = request.getTitle();
        this.contents = request.getContents();
    }
}
