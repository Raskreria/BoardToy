package com.viper.board.service.service;

import com.viper.board.persistence.entity.Board;
import com.viper.board.persistence.entity.User;
import com.viper.board.persistence.repository.BoardRepository;
import com.viper.board.persistence.repository.UserRepository;
import com.viper.board.service.model.dto.req.BoardReqDTO;
import com.viper.board.service.model.dto.res.BoardResDTO;
import com.viper.board.service.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final BoardMapper boardMapper;

    /*R : 게시판 리스트 읽기*/
    public List<BoardResDTO.READ> readBoardList(){
        final List<Board> boardList = boardRepository.findAll();
        return boardMapper.toReadDtoList(boardList);
    }

    /*R detail : 게시판 상세 읽기*/
    public BoardResDTO.READ readBoard(Long boardId){
        final Board board = boardRepository.findById(boardId).orElse(null);
        return boardMapper.toReadDto(board);
    }


    /*C : 게시판 생성*/
    @Transactional
    public void createBoard(BoardReqDTO.CREATE create){
        final User user = userRepository.findById(create.getWriterId()).orElse(null);
        final Board board = boardMapper.toBoardEntity(create, user);
        boardRepository.save(board);
    }

    /*U : 게시판 수정*/
    @Transactional
    public void updateBoard(Long boardId, BoardReqDTO.UPDATE update){
        final Board board = boardRepository.findById(boardId).orElse(null);
        if(board != null) {
            board.updateBoard(update);
            boardRepository.save(board);
        }
    }

    /*D : 게시판 삭제*/
    @Transactional
    public void deleteBoard(Long boardId){
        boardRepository.deleteById(boardId);
    }

}
