package com.viper.board.controller.controller;

import com.viper.board.service.service.BoardService;
import com.viper.board.service.service.ReplyService;
import com.viper.board.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ViewController {

    final BoardService boardService;
    final UserService userService;
    final ReplyService replyService;

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
