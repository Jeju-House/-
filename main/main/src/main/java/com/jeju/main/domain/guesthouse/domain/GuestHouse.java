package com.jeju.main.domain.guesthouse.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "guestHouse")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Data
@AllArgsConstructor
public class GuestHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestHouse_id")
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

