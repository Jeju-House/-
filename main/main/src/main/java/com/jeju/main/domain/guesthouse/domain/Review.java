package com.jeju.main.domain.guesthouse.domain;

import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Table(name = "review")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @OneToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "guest_house_id")
    private GuestHouse guestHouse;
}
