package com.viper.board.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {



//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//
//        this.userService = userService;
//    }
//
//    @PostMapping("auth")
//    public String auth(HttpSession session, UserDTO userDTO) {
//        UserDTO login =userService.auth(userDTO);
//        if(login!=null) {
//            session.setAttribute("login", login);
//            return "redirect:/board/showAll";
//        }else {
//            return "redirect:/";
//        }
//    }
//
//    @PostMapping("register")
//    public String register(UserDTO userDTO){
//        userService.register(userDTO);
//        return "redirect:/";
//    }
//
//    @GetMapping("register")
//    public String showRegister(UserDTO userDTO){
//
//        return "user/register";
//    }
}
