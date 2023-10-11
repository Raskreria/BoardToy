package com.viper.board.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board/")
public class BoardController {

//    private BoardService boardService;
//
//    @Autowired
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    @GetMapping("/")
    public String showHome() {
        return "index";
    }



//    @GetMapping("/board/showAll")
//    public ModelAndView printAll() {
//
//        ModelAndView mv = new ModelAndView();
//
//        mv.addObject("list",boardService.selectAll());
//
//        mv.setViewName("/board/showAll");
//
//        return mv;
//    }
//
//    @GetMapping("/board/write")
//    public String showWrite(){
//        return "board/write";
//    }
//    @PostMapping("/board/write")
//    public String write(HttpSession session, BoardDTO boardDTO) {
//        UserDTO login =(UserDTO)session.getAttribute("login");
//        if(login!=null){
//            boardDTO.setWriterId(login.getId());
//            boardService.insert(boardDTO);
//            return "fail";
//        }
//
//        return "redirect:/board/showAll";
//
//    }
//
//    @GetMapping("/board/showOne/{id}")
//    public String showOne(@PathVariable int id, HttpSession session, Model model){
//        BoardDTO boardDTO = boardService.selectOne(id);
//        model.addAttribute("board", boardDTO);
//        model.addAttribute("login", (UserDTO)session.getAttribute("login"));
//        return "/board/showOne";
//    }
}
