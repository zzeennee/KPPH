package com.kpph.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tree_follow")
public class Follow {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("팔로우 PK")
    private Integer followIdx;

    @NotNull
    @Comment("팔로우 사용자 고유번호")
    private Integer followIdIdx;

    @Column(length = 24)
    @NotNull
    @Comment("팔로우 닉네임")
    private String followName;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @Builder
    public Follow(Integer followIdx, Integer followIdIdx, String followName, User user) {
        this.followIdx = followIdx;
        this.followIdIdx = followIdIdx;
        this.followName = followName;
        this.user = user;
    }
}
