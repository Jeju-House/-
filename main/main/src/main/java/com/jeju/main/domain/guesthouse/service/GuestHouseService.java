package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.dto.request.GuestHouseRequestDto;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;
    public void addGuestHouse(GuestHouseRequestDto resource) {
        GuestHouse guestHouse = GuestHouse.builder()
                .name(resource.getName())
                .region(resource.getRegion())
                .promotion(resource.getPromotion()).build();
    }
    public void getGuestHouse(Long id) {
    }
}
