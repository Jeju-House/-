package com.jeju.main.domain.room.dto.response;

import com.jeju.main.domain.room.domain.Room;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomDetailResponse {
    private Long roomId;
    private Long price;
    private Long wholePerson;
    private Long extraPerson;

    public static RoomDetailResponse of(Room room){
        return RoomDetailResponse.builder()
                .roomId(room.getId())
                .price(room.getPrice())
                .wholePerson(room.getWholePerson())
                .extraPerson(room.getExtraPerson())
                .build();
    }
}
