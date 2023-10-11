package com.viper.board.controller.restcontroller;

import com.viper.board.service.model.dto.req.ReplyReqDTO;
import com.viper.board.service.model.dto.res.ReplyResDTO;
import com.viper.board.service.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reply/")
public class ReplyController {

    final ReplyService replyService;

    /*R : 게시판 댓글 리스트*/
    @GetMapping("{boardId}/list")
    public List<ReplyResDTO.READ> getBoardList(@PathVariable(name="boardId") Long boardId){
        return replyService.readReplyList(boardId);
    }


    /*C : 게시판 댓글 생성*/
    @PostMapping("write")
    public void createBoard(@RequestBody ReplyReqDTO.CREATE create){
        replyService.createReply(create);
    }

//    /*U : 게시판 댓글 수정*/
//    @PutMapping("renew/{boardId}")
//    public void createBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody BoardReqDTO.UPDATE update){
//        boardService.updateBoard(boardId, update);
//    }
//
//    /*D 게시판 댓글 삭제 */
//    @DeleteMapping("delete/{boardId}")
//    public void createBoard(@PathVariable(name = "boardId") Long boardId){
//        boardService.deleteBoard(boardId);
//    }


}
