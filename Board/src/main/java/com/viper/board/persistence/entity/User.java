package com.viper.board.persistence.entity;

import com.viper.board.persistence.BaseEntity;
import com.viper.board.service.model.dto.req.UserReqDTO;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "id")
)
public class User extends BaseEntity {
    @Column(name = "username", nullable = false, unique = true, length = 10, updatable = false)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "nickname", nullable = false, length = 16)
    private String nickname;

    @Column(name="email", nullable = false, length = 30)
    private String email;

    @Builder
    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public void updateUser(UserReqDTO.UPDATE update){
        this.password = update.getPassword();
        this.nickname = update.getNickname();
        this.email = update.getEmail();
    }
}