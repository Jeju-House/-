package com.jeju.main.domain.guesthouse.domain;


import jakarta.persistence.*;
import jakarta.servlet.http.Part;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "guest_house")
    @Builder.Default
    private List<Party> parties = new ArrayList<>();
    @OneToMany(mappedBy = "guest_house")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}
