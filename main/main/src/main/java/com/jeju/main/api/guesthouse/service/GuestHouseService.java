package com.jeju.main.api.guesthouse.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.jeju.main.domain.guesthouse.domain.GuestHouse;

import com.jeju.main.domain.guesthouse.dto.response.GuestHouseDetailResponse;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.guesthouse.dto.response.GuestHousesResponseDto;
import com.jeju.main.domain.guesthouse.repository.GuestHouseRepository;

import java.io.IOException;
import java.util.List;

import com.jeju.main.domain.guesthouse.service.GuestHouseModifier;
import com.jeju.main.domain.guesthouse.service.GuestHouseReader;
import com.jeju.main.domain.room.domain.Room;
import com.jeju.main.domain.room.dto.response.RoomDetailResponse;
import com.jeju.main.domain.room.service.RoomReader;
import com.jeju.main.global.error.ErrorCode;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GuestHouseService {
    @Value("${cloud.aws.s3.bucket}")
    private final String bucket;
    private final AmazonS3Client amazonS3Client;
    private final GuestHouseReader guestHouseReader;
    private final GuestHouseModifier guestHouseModifier;
    private final RoomReader roomReader;

    @Transactional
    public void addGuestHouse(GuestHouseResponseDto resource, MultipartFile file) throws IOException {
        //리팩토링 필요!!
        String image = file.getOriginalFilename();
        String url= "https://" + bucket + "/test" +image;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        amazonS3Client.putObject(bucket,image,file.getInputStream(),metadata);

        GuestHouse guestHouse = GuestHouse.createGuestHouse(resource, url);

        guestHouseModifier.save(guestHouse);
    }

    public GuestHouseDetailResponse getGuestHouseDetail(Long guestHouseId){
        GuestHouse guestHouse = guestHouseReader.findGuestHouseById(guestHouseId);
        List<Room> rooms = roomReader.findAllRoomByGuestHouseId(guestHouseId);
        List<RoomDetailResponse> roomDetailResponse = createRoomDetailResponse(rooms);
        return GuestHouseDetailResponse.of(guestHouse,roomDetailResponse);
    }

    public GuestHouseResponseDto getGuestHouse(Long id) {

        GuestHouse guestHouse = guestHouseReader.findGuestHouseById(id);

        return GuestHouseResponseDto.of(guestHouse);
    }

    public List<GuestHouseResponseDto> getByRegionGuestHouses(String region) {
        List<GuestHouse> guestHouses = guestHouseReader.findGuestHouseByRegion(region);

        return GuestHousesResponseDto.mapToResponseDtoList(guestHouses);
    }

    private List<RoomDetailResponse> createRoomDetailResponse(List<Room> rooms){
        return rooms.stream().map(RoomDetailResponse::of).toList();
    }
}
