package com.viper.board.service.model.dto.req;

import lombok.*;

public class UserReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CREATE{

        private String username;
        private String password;
        private String nickname;
        private String email;

    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UPDATE{

        private String password;
        private String nickname;
        private String email;

    }
}
