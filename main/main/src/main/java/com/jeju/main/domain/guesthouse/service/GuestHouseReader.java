package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import com.jeju.main.global.error.ErrorCode;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestHouseReader {

    private final GuestHouseRepository guestHouseRepository;

    public GuestHouse findGuestHouseById(Long id){
        return guestHouseRepository.findById(id).orElseThrow(()->new EntityNotFoundException(ErrorCode.GUESTHOUSE_NOT_FOUND));
    }

    public List<GuestHouse> findGuestHouseByRegion(String region){
        return guestHouseRepository.findByRegion(region);
    }
}
