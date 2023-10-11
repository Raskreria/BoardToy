package com.viper.board.service.model.dto.res;

import lombok.*;

import java.time.LocalDateTime;

public class ReplyResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long id;
        private String content;
        private Long writerId;
        private Long boardId;
        private LocalDateTime regDate;
        private LocalDateTime modDate;
    }
}
