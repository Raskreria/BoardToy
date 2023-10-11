package com.viper.board.service.service;

import com.viper.board.persistence.entity.User;
import com.viper.board.persistence.repository.UserRepository;
import com.viper.board.service.model.dto.req.UserReqDTO;
import com.viper.board.service.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class UserService {

    final UserRepository userRepository;
    final UserMapper userMapper;
    
    /*C : 유저 생성 */
    @Transactional
    public void createUser(UserReqDTO.CREATE create){
        final User user = userMapper.toUserEntity(create);
        userRepository.save(user);
    }

    /*U : 유저 수정 */
    @Transactional
    public void updateUser(Long userId,UserReqDTO.UPDATE update){
        final Optional<User> user = userRepository.findById(userId);
        user.get().updateUser(update);
        userRepository.save(user.get());
    }

    /*D : 유저 삭제 */
    @Transactional
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

}
