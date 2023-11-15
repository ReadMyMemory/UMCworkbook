package umc.week7.domain.mapping;

import lombok.*;
import umc.week7.domain.Mission;
import umc.week7.domain.base.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionReview extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id") // 이렇게 해놓으면 mission id 어떻게 찾을까? mission_id는 그냥 내가 명시해준 게 아닌가?
    private Mission mission;

    @Column(nullable = false, length = 50)
    private Long stars;

    @Column(nullable = false, length = 1024)
    private String contents;
}