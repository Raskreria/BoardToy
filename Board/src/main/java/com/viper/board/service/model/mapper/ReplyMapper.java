package com.viper.board.service.model.mapper;

import com.viper.board.persistence.entity.Board;
import com.viper.board.persistence.entity.Reply;
import com.viper.board.persistence.entity.User;
import com.viper.board.service.model.dto.req.ReplyReqDTO;
import com.viper.board.service.model.dto.res.ReplyResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "board", source = "board")
    @Mapping(target = "content", source = "create.content")
    Reply toReplyEntity(ReplyReqDTO.CREATE create, User user, Board board);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "writerId", source = "reply.user", qualifiedByName = "mapUserToUserId")
//    @Mapping(target = "boardId", source = "reply.board", qualifiedByName = "mapBoardToBoardId")
//    ReplyResDTO.READ toReadDto(Reply reply);

    List<ReplyResDTO.READ> toReadDtoList(List<Reply> replyList);
    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
    @Named("mapBoardToBoardId")
    default Long mapBoardToBoardId(Board board) {
        return board.getId();
    }
}

