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
@Table(name = "tree_sticker_info")
public class StickerInfo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("스티커 정보 PK")
    private Integer stickerInfoIdx;

    @Column(length = 500)
    @NotNull
    @Comment("스티커 이미지 경로")
    private String stickerInfoImagePath;

    @NotNull
    @Comment("스티커 사용여부 1: 사용, 0 : 미사용")
    @ColumnDefault("1")
    private Integer stickerInfoStatus;

    @Builder
    public StickerInfo(Integer stickerInfoIdx, String stickerInfoImagePath, Integer stickerInfoStatus) {
        this.stickerInfoIdx = stickerInfoIdx;
        this.stickerInfoImagePath = stickerInfoImagePath;
        this.stickerInfoStatus = stickerInfoStatus;
    }
}
