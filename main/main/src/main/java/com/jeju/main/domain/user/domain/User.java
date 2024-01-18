package com.jeju.main.domain.user.domain;

import com.jeju.main.domain.guesthouse.domain.Party;
import com.jeju.main.domain.guesthouse.domain.Review;
import com.jeju.main.domain.reservation.domain.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "user")
@Entity
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
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Party> partyList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Reservation> reservationList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();
}
