package com.jeju.main.api.guesthouse.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.jeju.main.api.guesthouse.service.GuestHouseService;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseDetailResponse;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.global.common.SuccessResponse;
import java.io.IOException;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guesthouse")
public class GuestHouseController {

    private final GuestHouseService guestHouseService;

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> searchGuestHouse(@PathVariable("id") Long guestHouseId){
        GuestHouseResponseDto guestHouseResponseDto = guestHouseService.getGuestHouse(guestHouseId);
        return SuccessResponse.ok(guestHouseResponseDto);
    }

    @GetMapping("/detail")
    public ResponseEntity<SuccessResponse<?>> getGuestHouseDetail(@RequestParam("guestHouseId") Long guestHouseId){
        GuestHouseDetailResponse guestHouseDetail = guestHouseService.getGuestHouseDetail(guestHouseId);
        return SuccessResponse.ok(guestHouseDetail);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> createGuest(@RequestBody GuestHouseResponseDto guestHouseResponseDto,
                                                          MultipartFile file) throws IOException{
        guestHouseService.addGuestHouse(guestHouseResponseDto,file);

        return SuccessResponse.created(null);

    }
    @GetMapping("/region")
    public ResponseEntity<SuccessResponse<?>> searchByRegionGuestHouses(@RequestParam("region") String region){
        List<GuestHouseResponseDto> guestHouseResponseDtos = guestHouseService.getByRegionGuestHouses(region);

        return SuccessResponse.ok(guestHouseResponseDtos);
    }
}
