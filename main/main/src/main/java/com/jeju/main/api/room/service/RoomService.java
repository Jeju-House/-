package com.jeju.main.api.room.service;

import com.jeju.main.domain.room.domain.Room;
import com.jeju.main.domain.room.dto.request.RoomDetailRequest;
import com.jeju.main.domain.room.dto.response.RoomDetailResponse;
import com.jeju.main.domain.room.repository.RoomRepository;
import com.jeju.main.domain.room.service.RoomReader;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.jeju.main.global.error.ErrorCode.ROOM_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomReader roomReader;
    public RoomDetailResponse getRoomDetail(RoomDetailRequest roomDetailRequest){
        Room room = roomReader.findRoomByRoomId(roomDetailRequest.getRoomId());
        return RoomDetailResponse.of(room);
    }

}
