package com.example.springboot_react_example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.time.LocalDateTime;

@Log4j2
@Entity
@Table(name = "TB_FILE")
@Getter
@ToString
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originFileName;
    private String storedFileName;
    private String filePath;
    private String fileType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @Setter
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    @Builder
    public FileEntity(Long id,String originFileName,String storedFileName,String filePath,String fileType,LocalDateTime createdAt){
        this.id = id;
        this.originFileName = originFileName;
        this.storedFileName = storedFileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.createdAt = createdAt;
    }

    public void setMappingBoard(BoardEntity board) {
        this.board = board;
        if(!board.getFileEntityList().contains(this)){
            board.getFileEntityList().add(this);
        }
    }
}
