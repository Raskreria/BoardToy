package com.viper.board.persistence.entity;

import com.viper.board.persistence.BaseEntity;
import com.viper.board.service.model.dto.req.ReplyReqDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="reply")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name="id",
        column = @Column(name="id")
)
public class Reply extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    private Board board;


    @Column(name="content")
    private String content;

    @Builder
    public Reply(User user, Board board, String content) {
        this.user = user;
        this.board = board;
        this.content = content;
    }
    public void updateReply(ReplyReqDTO.UPDATE update){
        this.content = update.getContent();

    }
}
