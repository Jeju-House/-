package com.jeju.main.domain.reservation.domain;

import com.jeju.main.domain.guesthouse.domain.Room;
import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "reservation")
@Entity
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime StartDate;
    private LocalDateTime EndDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
