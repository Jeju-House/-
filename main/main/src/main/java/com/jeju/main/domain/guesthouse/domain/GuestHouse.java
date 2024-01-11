package com.jeju.main.domain.guesthouse.domain;


import jakarta.persistence.*;
import jakarta.servlet.http.Part;
import java.util.List;
import lombok.*;

@Entity
@Table(name="guest_house")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_house_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String promotion;
    @OneToMany
    @JoinColumn(name = "guest_house_id")
    private List<Party> parties;
}
