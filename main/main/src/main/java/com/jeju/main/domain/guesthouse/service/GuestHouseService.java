package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;

import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import com.jeju.main.domain.guesthouse.dto.request.GuestHouseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;
    public void addGuestHouse(GuestHouseRequestDto resource) {
    }
    public void getGuestHouse(Long id) {
    }
}
