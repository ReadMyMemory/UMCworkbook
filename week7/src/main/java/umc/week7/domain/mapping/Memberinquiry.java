package umc.week7.domain.mapping;

import lombok.*;
import umc.week7.domain.Member;
import umc.week7.domain.base.BaseEntity;
import umc.week7.domain.enums.InquiryStatus;
import umc.week7.domain.enums.Status;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Memberinquiry extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 1024)
    private String contents;

    @Column(columnDefinition = "VARCHAR(30)")
    @Enumerated(EnumType.STRING)
    private InquiryStatus status;



}
