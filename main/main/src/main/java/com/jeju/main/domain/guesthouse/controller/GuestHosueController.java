package com.jeju.main.domain.guesthouse.controller;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.dto.request.GuestHouseRequestDto;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.guesthouse.service.GuestHouseService;
import com.jeju.main.global.common.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/guesthouse")
public class GuestHosueController {
    private final GuestHouseService guestHouseService;
    @GetMapping("{id}")
    public ResponseEntity<SuccessResponse<?>> searchGuestHouse(@PathVariable("id") Long guestHouseId){
        GuestHouseResponseDto guestHouseResponseDto = guestHouseService.getGuestHouse(guestHouseId);
        return SuccessResponse.ok(guestHouseResponseDto);
    }
    @PostMapping("")
    public ResponseEntity<SuccessResponse<?>> createGuest(@RequestBody GuestHouseResponseDto guestHouseResponseDto){
        guestHouseService.addGuestHouse(guestHouseResponseDto);
        return SuccessResponse.created(null);
    }
    /*@GetMapping("")
    public ResponseEntity<SuccessResponse<?>> searchGuestHouses(){
        List<GuestHouseResponseDto> guestHouseResponseDtos = guestHouseService.getGuestHouse()
    }*/
}
