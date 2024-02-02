package com.jeju.main.domain.user.domain;

import com.jeju.main.domain.guesthouse.domain.Party;
import com.jeju.main.domain.guesthouse.domain.Review;
import com.jeju.main.domain.reservation.domain.Reservation;
import com.jeju.main.domain.user.auth.UserInfo;
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
    private String refreshToken;
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Party> partyList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Reservation> reservationList = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    public static User createUser(String account, String password, String gender, Role role) {
        return User.builder()
                .account(account)
                .password(password)
                .gender(gender)
                .role(role)
                .build();
    }
    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
