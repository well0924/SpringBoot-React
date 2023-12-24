package com.example.springboot_react_example.controller;

import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.BoardRequest;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import com.example.springboot_react_example.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/board")
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;
    
    //글 목록
    @GetMapping("/list")
    public ResponseEntity<?> listAll(@PageableDefault(size = 10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        Page<BoardResponse> list = boardService.listALL(pageable);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //글 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<?>getBoard(@PathVariable("id") Long boardId){
        BoardResponse response = boardService.getBoard(boardId);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    //글 작성
    @PostMapping("/create")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<?>createBoard(@RequestBody BoardRequest request){
        Long createdResult = boardService.createBoard(request);
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행 중인 스레드: " + currentThread.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResult);
    }

    //글 수정
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public ResponseEntity<?>updateBoard(@RequestBody BoardRequest request,@PathVariable("id")Long boardId,@AuthenticationPrincipal Member member){
        Long updateResult = boardService.updateBoard(boardId,request,member);
        return ResponseEntity.status(HttpStatus.OK).body(updateResult);
    }

    //글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteBoard(@PathVariable("id")Long boardId){
        boardService.deleteBoard(boardId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
