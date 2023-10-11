package com.viper.board.controller.restcontroller;

import com.viper.board.service.model.dto.req.BoardReqDTO;
import com.viper.board.service.model.dto.res.BoardResDTO;
import com.viper.board.service.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/")
public class BoardRestController {


    final BoardService boardService;

    /*R : 게시판 리스트*/
    @GetMapping("list")
    public List<BoardResDTO.READ> getBoardList(){
        return boardService.readBoardList();
    }

    /*R detail : 게시판 상세*/
    @GetMapping("detail/{boardId}")
    public BoardResDTO.READ getBoard(@PathVariable(name="boardId")Long boardId){
        return boardService.readBoard(boardId);
    }


    /*C : 게시판 생성*/
    @PostMapping("write")
    public void createBoard(@RequestBody BoardReqDTO.CREATE create){
        boardService.createBoard(create);
    }

    /*U : 게시판 수정*/
    @PutMapping("renew/{boardId}")
    public void createBoard(@PathVariable(name = "boardId") Long boardId, @RequestBody BoardReqDTO.UPDATE update){
        boardService.updateBoard(boardId, update);
    }

    /*D 게시판 삭제 */
    @DeleteMapping("delete/{boardId}")
    public void createBoard(@PathVariable(name = "boardId") Long boardId){
        boardService.deleteBoard(boardId);
    }


}
