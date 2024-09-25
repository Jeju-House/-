package com.jeju.main.domain.guesthouse.domain;


import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.user.domain.Role;
import com.jeju.main.domain.user.domain.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "guestHouse")
@Entity
public class GuestHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestHouse_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String image;
    private String promotion;

    public static GuestHouse createGuestHouse(GuestHouseResponseDto resource, String url) {
        return GuestHouse.builder()
                .name(resource.getName())
                .region(resource.getRegion())
                .promotion(resource.getPromotion())
                .image(url)
                .build();
    }
}

