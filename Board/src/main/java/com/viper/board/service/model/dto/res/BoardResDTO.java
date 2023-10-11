package com.viper.board.service.model.dto.res;

import lombok.*;

import java.time.LocalDateTime;

public class BoardResDTO {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{
        private Long id;
        private String title;
        private String content;
        private Long writerId;
        private LocalDateTime regDt;
        private LocalDateTime modDt;
    }
}
