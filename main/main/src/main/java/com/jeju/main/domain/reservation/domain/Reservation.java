package com.jeju.main.domain.reservation.domain;

import com.jeju.main.domain.guesthouse.domain.Room;
import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime StartDate;
    private LocalDateTime EndDate;
    @OneToMany(mappedBy = "reservation")
    private List<User> users = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
