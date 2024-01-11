package com.jeju.main.domain.guesthouse.domain;

import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;
    private String party_name;
    private LocalDateTime party_date;
    @ManyToOne
    @JoinColumn(name="guest_house_id")
    private GuestHouse guestHouse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<User> users;

}
