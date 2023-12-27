package com.example.springboot_react_example.controller;

import com.example.springboot_react_example.domain.dto.FileDownloadDto;
import com.example.springboot_react_example.domain.dto.FileUploadDto;
import com.example.springboot_react_example.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload/{id}")
    public ResponseEntity<?>upload(@PathVariable("id") Long boardId,
                                   @RequestParam("file") List<MultipartFile> files)throws Exception{
        List<FileUploadDto>list = fileService.fileUpload(boardId,files);
        log.info(list);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource>download(@PathVariable("id")Long fileId)throws Exception{
        FileDownloadDto downloadDto = fileService.download(fileId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(downloadDto.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + downloadDto.getFilename() + "\"")
                .body(new ByteArrayResource(downloadDto.getContent()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>fileDelete(@PathVariable("id") Long fileId){
        fileService.delete(fileId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
