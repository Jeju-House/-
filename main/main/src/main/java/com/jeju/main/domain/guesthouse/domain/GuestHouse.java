package com.jeju.main.domain.guesthouse.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "guest_house")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class GuestHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_house_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String promotion;

    @OneToMany(mappedBy = "guestHouse")  // Update the mappedBy attribute
    @Builder.Default
    private List<Party> parties = new ArrayList<>();

    @OneToMany(mappedBy = "guestHouse")  // Update the mappedBy attribute
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}

