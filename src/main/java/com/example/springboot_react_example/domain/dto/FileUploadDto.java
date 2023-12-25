package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.FileEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FileUploadDto {
    private Long id;
    private String originFileName;
    private String filePath;
    private String fileType;

    @Builder
    public FileUploadDto(Long id,String originFileName,String filePath,String fileType){
        this.id = id;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public static FileUploadDto fromEntity(FileEntity file) {
        return FileUploadDto.builder()
                .id(file.getId())
                .originFileName(file.getOriginFileName())
                .filePath(file.getFilePath())
                .fileType(file.getFileType())
                .build();
    }
}
