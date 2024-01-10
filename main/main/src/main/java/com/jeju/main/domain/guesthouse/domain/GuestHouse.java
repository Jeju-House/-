package com.jeju.main.domain.guesthouse.domain;


import jakarta.persistence.*;
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
}
