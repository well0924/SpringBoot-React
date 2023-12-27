package com.example.springboot_react_example.domain;

import com.example.springboot_react_example.domain.dto.BoardRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    //회원
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", referencedColumnName = "id")
    private Member member;

    //댓글
    @BatchSize(size = 10)
    @ToString.Exclude
    @OneToMany(mappedBy = "board",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment>commentList = new ArrayList<>();

    //파일
    @BatchSize(size = 10)
    @ToString.Exclude
    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<FileEntity>fileEntityList = new ArrayList<>();

    @Builder
    public BoardEntity(String title, String contents, String createdBy, LocalDateTime createdAt, Member member){
        this.title = title;
        this.contents = contents;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.member = member;
    }

    //게시글 수정
    public void boardUpdate(BoardRequest request){
        this.title = request.getTitle();
        this.contents = request.getContents();
    }

    public void addFileEntity(FileEntity fileEntity) {
        fileEntityList.add(fileEntity);
        fileEntity.setBoard(this);
    }
}
