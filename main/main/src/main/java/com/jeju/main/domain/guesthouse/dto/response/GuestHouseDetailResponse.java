package com.jeju.main.domain.guesthouse.dto.response;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.domain.Region;
import com.jeju.main.domain.room.domain.Room;
import com.jeju.main.domain.room.dto.response.RoomDetailResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GuestHouseDetailResponse {
    private Long guestHouseId;
    private String name;
    private Region region;
    private String image;
    private String promotion;
    private List<RoomDetailResponse> roomDetailResponses;
    public static GuestHouseDetailResponse of(GuestHouse guestHouse, List<RoomDetailResponse> roomDetailResponses){
        return GuestHouseDetailResponse.builder()
                .guestHouseId(guestHouse.getId())
                .name(guestHouse.getName())
                .region(guestHouse.getRegion())
                .image(guestHouse.getImage())
                .promotion(guestHouse.getPromotion())
                .roomDetailResponses(roomDetailResponse)
                .build();
    }
}
