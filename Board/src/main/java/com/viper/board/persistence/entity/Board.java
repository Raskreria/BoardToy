package com.viper.board.persistence.entity;

import com.viper.board.persistence.BaseEntity;
import com.viper.board.service.model.dto.req.BoardReqDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="board")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name="id",
        column = @Column(name="id")
)
public class Board extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private User user;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Builder
    public Board(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updateBoard(BoardReqDTO.UPDATE update){
        this.title = update.getTitle();
        this.content = update.getContent();
    }
}