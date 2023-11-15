package umc.week7.domain;

import lombok.*;
import umc.week7.domain.base.BaseEntity;
import umc.week7.domain.enums.Gender;
import umc.week7.domain.enums.Status;
import umc.week7.domain.mapping.MemberMission;
import umc.week7.domain.mapping.Memberfavor;
import umc.week7.domain.mapping.Memberinquiry;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "VARCHAR(20)") // 굳이 왜??
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //@Column(nullable = false) 달아야할까?

    private LocalDate birth;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 100)
    private String address;

    private Long point;

    @Column(nullable = false, length = 50)
    private String phoneNum;

    @Column(columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private Status isDeleted;

    @Column(columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    private Status isAuth;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Memberfavor> memberfavorList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Memberinquiry> memberinquiryList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}