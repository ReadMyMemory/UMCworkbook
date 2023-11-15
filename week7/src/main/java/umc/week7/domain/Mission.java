package umc.week7.domain;
import lombok.*;
import umc.week7.domain.base.BaseEntity;
import umc.week7.domain.mapping.MemberMission;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String restaurantName;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, length = 100)
    private String standardPrice;

    @Column(nullable = false, length = 100)
    private String accumulatePoint;

    @Column(nullable = false, length = 100)
    private LocalDate endDate;

    @Column(nullable = false, length = 100)
    private String location;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
