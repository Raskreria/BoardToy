package com.viper.board.controller.controller;

import com.viper.board.service.service.BoardService;
import com.viper.board.service.service.ReplyService;
import com.viper.board.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ViewController {

    final BoardService boardService;
    final UserService userService;
    final ReplyService replyService;

    //AWS상의 form태그를 통한 post request 테스트 : 통과
    @PostMapping("/test")
    public void postTest(@RequestParam(name="test") String data){
        System.out.println("data = " + data);
    }

    @GetMapping("/join")
    public String showJoin() {
        return "login/join";
    }

    @GetMapping("/board")
    public String showBoard() {
        return "board/board";
    }

    @GetMapping("/")
    public String showHomeLogin() {
        return "login/login";
    }



    @GetMapping("/board/detail/{boardId}")
    public String showBoardDetail(Model model, @PathVariable Long boardId) {

        model.addAttribute("board", boardService.readBoard(boardId));
        model.addAttribute("replyList", replyService.readReplyList(boardId));

        return "board/detail";
    }
}
