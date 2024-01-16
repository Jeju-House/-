package com.jeju.main.domain.guesthouse.domain;

import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "party")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    @OneToMany(mappedBy = "party")
    @Builder.Default
    private List<User> users = new ArrayList<>();

}
