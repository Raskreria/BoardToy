package com.viper.board.controller.restcontroller;

import com.viper.board.service.model.dto.req.UserReqDTO;
import com.viper.board.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserRestController {


    final UserService userService;



    /*C : 유저 생성*/
    @PostMapping("create")
    public void createUser(@RequestBody UserReqDTO.CREATE create){
        userService.createUser(create);
    }

    /*U : 유저 수정*/
    @PutMapping("renew/{userId}")
    public void updateBoard(@PathVariable(name = "userId") Long boardId, @RequestBody UserReqDTO.UPDATE update){
        userService.updateUser(boardId, update);
    }

    /*D 유저 삭제 */
    @DeleteMapping("delete/{userId}")
    public void deleteBoard(@PathVariable(name = "userId") Long userId){
        userService.deleteUser(userId);
    }
}
