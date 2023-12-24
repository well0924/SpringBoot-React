package com.example.springboot_react_example.service;

import com.example.springboot_react_example.domain.BoardEntity;
import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.BoardRequest;
import com.example.springboot_react_example.domain.dto.BoardResponse;
import com.example.springboot_react_example.repository.BoardEntityRepository;
import com.example.springboot_react_example.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class BoardService {
    private final BoardEntityRepository boardEntityRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<BoardResponse> listALL(Pageable pageable){
        return boardEntityRepository.findAllList(pageable);
    }

    @Transactional
    public Integer boardCount(){
        return boardEntityRepository.boardCount();
    }

    @Transactional(readOnly = true)
    public BoardResponse getBoard(Long boardId){
        BoardEntity entity = boardEntityRepository.findById(boardId).get();
        return BoardResponse.builder().board(entity).build();
    }

    @Transactional
    public Long createBoard(BoardRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName().toString();
        log.info(username);
        Member member = userRepository.findByUserId(username).get();

        BoardEntity entity = BoardEntity
                .builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .member(member)
                .createdBy(member.getUserId())
                .createdAt(LocalDateTime.now())
                .build();

        boardEntityRepository.save(entity);

        return entity.getIdx();
    }

    @Transactional
    public Long updateBoard(Long boardId,BoardRequest request,Member member){

        Optional<BoardEntity> board = boardEntityRepository.findById(boardId);

        member = userRepository.findById(member.getId()).get();

        BoardEntity result = board.get();

        if(!result.getCreatedBy().equals(member.getUserId())){
            throw new RuntimeException("작성자가 일치하지 않습니다.");
        }

        result.boardUpdate(request);

        boardEntityRepository.save(result);

        return result.getIdx();
    }

    public void deleteBoard(Long boardId){
        boardEntityRepository.deleteById(boardId);
    }
}
