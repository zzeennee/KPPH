package com.kpph.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tree_letter")
public class Letter {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("편지 PK")
    private Integer letterIdx;

    @Column(length = 200)
    @NotNull
    @Comment("편지 제목")
    private String letterTitle;

    @Lob
    @Comment("편지 내용")
    private String letterContent;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("편지보낸시간")
    private Date letterSendDate;

    @NotNull
    @Comment("편지 수신자 idx")
    private int letterReceiveTargetIdx;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("편지받은시간")
    private Date letterReceiveDate;

    @NotNull
    @Comment("편지 확인 여부 1: 확인, 0: 미확인")
    @ColumnDefault("0")
    private Integer letterCheck;

    @NotNull
    @Comment("좋아요 여부 1: 좋아요, 0: 좋아요 아님")
    @ColumnDefault("0")
    private Integer letterLike;

    @NotNull
    @Comment("편지 공개 여부 1: 공개, 0: 미공개")
    @ColumnDefault("0")
    private Integer letterPublicStatus;

    @NotNull
    @Comment("북마크 여부 1: 북마크 상태, 0: 북마크 미상태")
    @ColumnDefault("0")
    private Integer letterBookmarkStatus;

    @NotNull
    @Comment("익명 여부 1 : 익명, 0: 익명아님")
    @ColumnDefault("0")
    private Integer letterAnonymous;

    @NotNull
    @Comment("편지 종류 1 : 편지, 2: 답장")
    @ColumnDefault("1")
    private Integer letterType;

    @NotNull
    @Comment("신고 여부 1: 신고, 0: 미신고")
    @ColumnDefault("0")
    private Integer letterReportStatus;

    @Column(length = 500)
    @Comment("신고내용")
    private String letterReportContent;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("신고일시")
    private Date letterReportDate;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @Builder

    public Letter(Integer letterIdx, String letterTitle, String letterContent, Date letterSendDate, int letterReceiveTargetIdx, Date letterReceiveDate, Integer letterCheck, Integer letterLike, Integer letterPublicStatus, Integer letterBookmarkStatus, Integer letterAnonymous, Integer letterType, Integer letterReportStatus, String letterReportContent, Date letterReportDate, User user) {
        this.letterIdx = letterIdx;
        this.letterTitle = letterTitle;
        this.letterContent = letterContent;
        this.letterSendDate = letterSendDate;
        this.letterReceiveTargetIdx = letterReceiveTargetIdx;
        this.letterReceiveDate = letterReceiveDate;
        this.letterCheck = letterCheck;
        this.letterLike = letterLike;
        this.letterPublicStatus = letterPublicStatus;
        this.letterBookmarkStatus = letterBookmarkStatus;
        this.letterAnonymous = letterAnonymous;
        this.letterType = letterType;
        this.letterReportStatus = letterReportStatus;
        this.letterReportContent = letterReportContent;
        this.letterReportDate = letterReportDate;
        this.user = user;
    }
}
