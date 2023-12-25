package com.example.springboot_react_example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_FILE")
@Getter
@ToString
public class FileEntity {
    @Id
    @Column(name = "file_id")
    private Long id;
    private String originFileName;
    private String filePath;
    private String fileType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    @Builder
    public FileEntity(Long id,String originFileName,String filePath,String fileType,LocalDateTime createdAt){
        this.id = id;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.createdAt = createdAt;
    }

    public void setMappingBoard(BoardEntity board) {
        this.board = board;
    }
}
