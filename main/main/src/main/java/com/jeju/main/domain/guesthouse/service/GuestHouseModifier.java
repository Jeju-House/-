package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestHouseModifier {
    private final GuestHouseRepository guestHouseRepository;

    public GuestHouse save(GuestHouse guestHouse){
        return guestHouseRepository.save(guestHouse);
    }
}
