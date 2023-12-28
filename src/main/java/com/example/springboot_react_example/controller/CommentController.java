package com.example.springboot_react_example.controller;

import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.CommentRequest;
import com.example.springboot_react_example.domain.dto.CommentResponse;
import com.example.springboot_react_example.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/list/{board-id}")
    public ResponseEntity<?>commentList(@PathVariable("board-id")Long boardId){
        List<CommentResponse>list = commentService.commentResponseList(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/create/{board-id}")
    public ResponseEntity<?>commentCreate(@RequestBody CommentRequest request,@PathVariable("board-id")Long boardId){
        Long result = commentService.createComment(request,boardId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/delete/{comment-id}")
    public ResponseEntity<?>commentDelete(@PathVariable("comment-id")Long commentId){
        commentService.commentDelete(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
