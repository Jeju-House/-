package com.jeju.main.domain.guesthouse.domain;

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
@Table(name = "party")
@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;
    private String party_name;
    private LocalDateTime party_date;
    @ManyToOne
    @JoinColumn(name="guestHouse_id")
    private GuestHouse guestHouse;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
