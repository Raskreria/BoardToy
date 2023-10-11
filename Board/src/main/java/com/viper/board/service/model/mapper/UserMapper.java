package com.viper.board.service.model.mapper;

import com.viper.board.persistence.entity.User;
import com.viper.board.service.model.dto.req.UserReqDTO;
import com.viper.board.service.model.dto.res.UserResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUserEntity(UserReqDTO.CREATE create);

    UserResDTO.READ toReadDto(User user);
}
