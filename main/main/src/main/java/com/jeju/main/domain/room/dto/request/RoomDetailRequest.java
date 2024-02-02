package com.jeju.main.domain.room.dto.request;

import lombok.Getter;

@Getter
public class RoomDetailRequest {
    private Long roomId;
    private Long guestHouseId;
    private Long userId;
}
