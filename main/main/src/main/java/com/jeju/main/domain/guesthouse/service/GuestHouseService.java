package com.jeju.main.domain.guesthouse.service;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;

import com.jeju.main.domain.guesthouse.dto.response.GuestHouseDetailResponse;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.guesthouse.dto.response.GuestHousesResponseDto;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;
import java.util.List;

import com.jeju.main.domain.room.dto.response.RoomDetailResponse;
import com.jeju.main.global.error.ErrorCode;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestHouseService {
    private final GuestHouseRepository guestHouseRepository;
    public void addGuestHouse(GuestHouseResponseDto resource,String url) {
        GuestHouse guestHouse = GuestHouse.builder()
                .name(resource.getName())
                .region(resource.getRegion())
                .promotion(resource.getPromotion())
                .image(url)
                .reviews(resource.getReviews())
                .parties(resource.getParties()).build();

        guestHouseRepository.save(guestHouse);
    }
    public GuestHouseDetailResponse getGuestHouseDetail(Long guestHouseId){
        GuestHouse guestHouse = findGuestHouseById(guestHouseId);
        List<RoomDetailResponse> roomDetailResponse = createRoomDetailResponse(guestHouse);
        return GuestHouseDetailResponse.of(guestHouse,roomDetailResponse);
    }
    public GuestHouseResponseDto getGuestHouse(Long id) {
        GuestHouse guestHouse = guestHouseRepository.findById(id).orElse(null);

        return GuestHouseResponseDto.of(guestHouse);
    }

    public List<GuestHouseResponseDto> getByRegionGuestHouses(String region) {
        List<GuestHouse> guestHouses = guestHouseRepository.findByRegion(region);

        return GuestHousesResponseDto.mapToResponseDtoList(guestHouses);
    }
    private List<RoomDetailResponse> createRoomDetailResponse(GuestHouse guestHouse){

    }
    private GuestHouse findGuestHouseById(Long id){
        return guestHouseRepository.findById(id).orElseThrow(()->new EntityNotFoundException(ErrorCode.GUESTHOUSE_NOT_FOUND));
    }
}
