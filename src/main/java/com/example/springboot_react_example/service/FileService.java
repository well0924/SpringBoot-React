package com.example.springboot_react_example.service;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.FileEntity;
import com.example.springboot_react_example.domain.dto.FileDownloadDto;
import com.example.springboot_react_example.domain.dto.FileUploadDto;
import com.example.springboot_react_example.repository.BoardEntityRepository;
import com.example.springboot_react_example.repository.FileEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileEntityRepository fileEntityRepository;
    private final BoardEntityRepository boardEntityRepository;

    @Value("${project.uploadPath}")
    private String uploadFilePath;

    //파일 업로드
    public List<FileUploadDto>fileUpload(Long boardId, List<MultipartFile> multipartFiles)throws Exception{
        BoardEntity board = boardEntityRepository.findById(boardId).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없습니다."));
        List<FileEntity>files = new ArrayList<>();

        for(MultipartFile multipartFile : multipartFiles){
            //파일 명
            String fileName = multipartFile.getOriginalFilename();
            //파일 아이디
            String randomId = UUID.randomUUID().toString();
            //저장된 파일명
            String storedFileName =
                    "FILE_" + board.getIdx() + "_" + randomId.concat(fileName.substring(fileName.indexOf(".")));

            String fileResourcePath = uploadFilePath + File.separator + uploadFilePath;

            File f = new File(uploadFilePath);

            if (!f.exists()) {
                f.mkdir();
            }

            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

            FileEntity saveFile = FileEntity.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .filePath(uploadFilePath)
                    .fileType(multipartFile.getContentType())
                    .build();
            saveFile.setMappingBoard(board);

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
        String filePath = uploadFilePath + file.getFilePath();
        String contentType = determineContentType(file.getFileType());
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
