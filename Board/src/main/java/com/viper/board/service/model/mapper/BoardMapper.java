package com.viper.board.service.model.mapper;

import com.viper.board.persistence.entity.Board;
import com.viper.board.persistence.entity.User;
import com.viper.board.service.model.dto.req.BoardReqDTO;
import com.viper.board.service.model.dto.res.BoardResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper{
    @Mapping(target = "user", source = "user")
    Board toBoardEntity(BoardReqDTO.CREATE create, User user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "writerId", source = "board.user", qualifiedByName = "mapUserToUserId")
    BoardResDTO.READ toReadDto(Board board);

    List<BoardResDTO.READ> toReadDtoList(List<Board> boardList);
    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
}