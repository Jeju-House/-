package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;

import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.guesthouse.dto.response.GuestHousesResponseDto;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;
    public void addGuestHouse(GuestHouseResponseDto resource) {
        GuestHouse guestHouse = GuestHouse.builder()
                .name(resource.getName())
                .region(resource.getRegion())
                .promotion(resource.getPromotion())
                .reviews(resource.getReviews())
                .parties(resource.getParties()).build();

        guestHouseRepository.save(guestHouse);
    }
    public GuestHouseResponseDto getGuestHouse(Long id) {
        GuestHouse guestHouse = guestHouseRepository.findById(id).orElse(null);

        return GuestHouseResponseDto.of(guestHouse);
    }

    public List<GuestHouseResponseDto> getByRegionGuestHouses(String region) {
        List<GuestHouse> guestHouses = guestHouseRepository.findByRegion(region);

        return GuestHousesResponseDto.mapToResponseDtoList(guestHouses);
    }
}
