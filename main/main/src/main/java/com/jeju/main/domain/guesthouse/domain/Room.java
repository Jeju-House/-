package com.jeju.main.domain.guesthouse.domain;

import com.jeju.main.domain.reservation.domain.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    private Long price;
    private Long wholePerson;
    private Long extraPerson;
    @ManyToOne
    @JoinColumn(name = "guest_house_id")
    private GuestHouse guestHouse;
    @OneToMany(mappedBy = "room")
    @Builder.Default
    private List<Reservation> reservationList = new ArrayList<>();
}
