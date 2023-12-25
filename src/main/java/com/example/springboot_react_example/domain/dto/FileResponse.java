package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class FileResponse {
    private Long id;
    private String originFileName;
    private String filePath;
    private String fileType;
    private LocalDateTime createdAt;

    @Builder
    public FileResponse(FileEntity fileEntity){
        this.id = fileEntity.getId();
        this.originFileName = fileEntity.getOriginFileName();
        this.filePath = fileEntity.getFilePath();
        this.fileType = fileEntity.getFileType();
        this.createdAt = fileEntity.getCreatedAt();
    }

    public static FileResponse fromToEntity(FileEntity fileEntity){
        return FileResponse
                .builder()
                .fileEntity(fileEntity)
                .build();
    }
}
