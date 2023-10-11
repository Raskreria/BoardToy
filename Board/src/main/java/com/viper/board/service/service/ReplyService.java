package com.viper.board.service.service;

import com.viper.board.persistence.entity.Board;
import com.viper.board.persistence.entity.Reply;
import com.viper.board.persistence.entity.User;
import com.viper.board.persistence.repository.BoardRepository;
import com.viper.board.persistence.repository.ReplyRepository;
import com.viper.board.persistence.repository.UserRepository;
import com.viper.board.service.model.dto.req.BoardReqDTO;
import com.viper.board.service.model.dto.req.ReplyReqDTO;
import com.viper.board.service.model.dto.res.ReplyResDTO;
import com.viper.board.service.model.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {

    final ReplyRepository replyRepository;
    final ReplyMapper replyMapper;

    final UserRepository userRepository;
    final BoardRepository boardRepository;

    /*R : 게시판 댓글 읽기*/
    public List<ReplyResDTO.READ> readReplyList(Long boardId){
        final List<Reply> replyList = replyRepository.findByBoardId(boardId);
        return replyMapper.toReadDtoList(replyList);
    }


    /*C : 게시판 댓글 생성*/
    @Transactional
    public void createReply(ReplyReqDTO.CREATE create){
        final User user = userRepository.findById(create.getWriterId()).orElse(null);
        final Board board = boardRepository.findById(create.getBoardId()).orElse(null);
        Reply reply = replyMapper.toReplyEntity(create, user, board);
        replyRepository.save(reply);
    }

    /*U : 게시판 댓글 수정*/
    @Transactional
    public void updateBoard(Long boardId, BoardReqDTO.UPDATE update){
        final Board board = boardRepository.findById(boardId).orElse(null);
        if(board != null) {
            board.updateBoard(update);
            boardRepository.save(board);
        }
    }

    /*D : 게시판 댓글 삭제*/
    @Transactional
    public void deleteReply(Long replyId){
        replyRepository.deleteById(replyId);
    }

}
