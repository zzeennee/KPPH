package com.kpph.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tree_user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("사용자 고유번호")
    private Integer userIdx;

    @Column(length = 50)
    @NotNull
    @Comment("사용자 아이디")
    private String userId;

    @Column(length = 500)
    @NotNull
    @Comment("사용자 비밀번호")
    private String userPw;

    @Column(length = 24)
    @NotNull
    @Comment("사용자 닉네임")
    private String userName;

    @Column(length = 500)
    @Comment("사용자 소개")
    private String userInfo;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("사용자 생일")
    private Date userBirth;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("사용자 가입 일자")
    private Date userJoinDate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("사용자 접속 일자")
    private Date userAccessDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("사용자 정보 수정 일자")
    private Date userModifyDate;

    @Column
    @ColumnDefault("1") // 0 : 탈퇴, 1 : 일반, 2 : 휴면
    @NotNull
    @Comment("사용자 상태")
    private Integer userStatus;

    @Builder
    public User(Integer userIdx, String userId, String userPw, String userName, String userInfo, Date userBirth, Date userJoinDate, Date userAccessDate, Date userModifyDate, Integer userStatus) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userInfo = userInfo;
        this.userBirth = userBirth;
        this.userJoinDate = userJoinDate;
        this.userAccessDate = userAccessDate;
        this.userModifyDate = userModifyDate;
        this.userStatus = userStatus;
    }
}
