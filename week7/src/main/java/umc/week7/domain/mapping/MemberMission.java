package umc.week7.domain.mapping;

import lombok.*;
import umc.week7.domain.Member;
import umc.week7.domain.Mission;
import umc.week7.domain.base.BaseEntity;
import umc.week7.domain.enums.Status;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(columnDefinition = "VARCHAR(30)")
    @Enumerated(EnumType.STRING)
    private Status isChallenged;

    @Column(columnDefinition = "VARCHAR(30)")
    @Enumerated(EnumType.STRING)
    private Status isReviewed;

    @Column(columnDefinition = "VARCHAR(30)")
    @Enumerated(EnumType.STRING)
    private Status isEnded;
}