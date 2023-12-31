package com.example.springboot_react_example.service;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.FileEntity;
import com.example.springboot_react_example.domain.dto.FileDownloadDto;
import com.example.springboot_react_example.domain.dto.FileUploadDto;
import com.example.springboot_react_example.repository.BoardEntityRepository;
import com.example.springboot_react_example.repository.FileEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class FileService {
    private final FileEntityRepository fileEntityRepository;
    private final BoardEntityRepository boardEntityRepository;

    @Value("${project.uploadPath}")
    private String uploadFilePath;

    //파일 업로드
    @Transactional
    public List<FileUploadDto>fileUpload(Long boardId, List<MultipartFile> multipartFiles)throws Exception{
        BoardEntity board = boardEntityRepository.findById(boardId).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없습니다."));
        log.info(board);
        List<FileEntity>files = new ArrayList<>();

        for(MultipartFile multipartFile : multipartFiles){
            //파일 명
            String fileName = multipartFile.getOriginalFilename();
            //파일 아이디
            String randomId = UUID.randomUUID().toString();
            //저장된 파일명
            String storedFileName =
                    "FILE_" + board.getIdx() + "_" + randomId.concat(fileName.substring(fileName.indexOf(".")));

            String fileResourcePath = uploadFilePath + File.separator + storedFileName;
            log.info(fileResourcePath);
            File f = new File(uploadFilePath);
            log.info("???:"+f);
            //읽기,쓰기 권한
            f.setWritable(true);
            f.setReadable(true);

            if (!f.exists()) {
                f.mkdir();
            }

            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));
            FileEntity saveFile = FileEntity.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .storedFileName(storedFileName)
                    .filePath(uploadFilePath)
                    .fileType(multipartFile.getContentType())
                    .createdAt(LocalDateTime.now())
                    .build();

            saveFile.setMappingBoard(board);
            log.info(saveFile);
            files.add(fileEntityRepository.save(saveFile));
        }
        List<FileUploadDto>dtos = files.stream().map(FileUploadDto::fromEntity).collect(Collectors.toList());
        return  dtos;
    }

    //파일 다운로드
    public FileDownloadDto download(Long fileId) throws IOException {
        FileEntity file = fileEntityRepository.findById(fileId).orElseThrow(
                () -> new FileNotFoundException()
        );
        log.info("fileDetail::"+file);
        String filePath = file.getFilePath()+file.getStoredFileName();
        log.info("download filePath :"+filePath);
        String contentType = determineContentType(file.getFileType());
        log.info(contentType);
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return FileDownloadDto.fromFileResource(file, contentType, content);
    }

    //파일 삭제
    public void delete(Long fileId) {
        FileEntity file = fileEntityRepository.findById(fileId).orElseThrow(() -> new RuntimeException("파일일 없습니다."));

        // local 파일을 삭제
        String filePath = uploadFilePath + File.separator + file.getFilePath();
        File physicalFile = new File(filePath);
        if (physicalFile.exists()) {
            physicalFile.delete();
        }
        fileEntityRepository.delete(file);
    }

    private String determineContentType(String contentType) {
        // ContentType에 따라 MediaType 결정
        switch (contentType) {
            case "image/png":
                return MediaType.IMAGE_PNG_VALUE;
            case "image/jpeg":
                return MediaType.IMAGE_JPEG_VALUE;
            case "text/plain":
                return MediaType.TEXT_PLAIN_VALUE;
            default:
                return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
