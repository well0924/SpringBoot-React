package com.example.springboot_react_example.service;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.Comment;
import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.CommentRequest;
import com.example.springboot_react_example.domain.dto.CommentResponse;
import com.example.springboot_react_example.repository.BoardEntityRepository;
import com.example.springboot_react_example.repository.CommentRepository;
import com.example.springboot_react_example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardEntityRepository boardEntityRepository;
    private final UserRepository userRepository;


    @Transactional(readOnly = true)
    public List<CommentResponse>commentResponseList(Long boardId){
        return commentRepository.commentList(boardId);
    }

    public Long createComment(CommentRequest request, Long boardId, Member member){

        BoardEntity board = boardEntityRepository.findById(boardId).get();

        Member writer = userRepository.findById(member.getId()).get();

        Comment comment = Comment
                .builder()
                .contents(request.getContents())
                .board(board)
                .member(writer)
                .createdBy(writer.getUserId())
                .build();

        commentRepository.save(comment);

        return comment.getId();
    }

    @Transactional
    public void commentDelete(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
