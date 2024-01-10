package com.jeju.main.domain.guesthouse.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="guest_house_id")
    private GuestHouse guestHouse;
}
