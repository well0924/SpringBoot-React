package com.example.springboot_react_example.domain.dto;

import com.example.springboot_react_example.domain.FileEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FileDownloadDto {

    private String filename;
    private String fileType;
    private byte[] content;

    @Builder
    public FileDownloadDto(String filename,String fileType,byte[]content){
        this.filename = filename;
        this.fileType = fileType;
        this.content = content;
    }

    public static FileDownloadDto fromFileResource(FileEntity file, String contentType, byte[] content) {
        return FileDownloadDto.builder()
                .filename(file.getOriginFileName())
                .fileType(contentType)
                .content(content)
                .build();
    }
}
