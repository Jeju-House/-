package com.jeju.main.domain.user.domain;

import com.jeju.main.domain.guesthouse.domain.Party;
import com.jeju.main.domain.guesthouse.domain.Review;
import com.jeju.main.domain.reservation.domain.Reservation;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String account;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @OneToOne
    private Review review;
}
