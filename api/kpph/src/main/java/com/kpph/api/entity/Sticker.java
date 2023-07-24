package com.kpph.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tree_sticker")
public class Sticker {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("스티커 PK")
    private Integer stickerIdx;

    @Column(length = 100)
    @NotNull
    @Comment("스티커 좌표")
    private String sticker_xy;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "letter_idx")
    private Letter letter;

    @ManyToOne
    @JoinColumn(name = "sticker_info_idx")
    private StickerInfo stickerInfo;

    @Builder
    public Sticker(Integer stickerIdx, String sticker_xy, User user, Letter letter, StickerInfo stickerInfo) {
        this.stickerIdx = stickerIdx;
        this.sticker_xy = sticker_xy;
        this.user = user;
        this.letter = letter;
        this.stickerInfo = stickerInfo;
    }
}
