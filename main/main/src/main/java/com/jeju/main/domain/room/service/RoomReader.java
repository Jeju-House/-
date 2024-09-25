package com.jeju.main.domain.room.service;

import com.jeju.main.domain.room.domain.Room;
import com.jeju.main.domain.room.repository.RoomRepository;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jeju.main.global.error.ErrorCode.ROOM_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class RoomReader {
    private final RoomRepository roomRepository;

    public Room findRoomByRoomId(Long roomId){
        return roomRepository.findById(roomId).orElseThrow(()->new EntityNotFoundException(ROOM_NOT_FOUND));
    }

    public List<Room> findAllRoomByGuestHouseId(Long guestHouseId){
        return roomRepository.findAllByGuestHouseId(guestHouseId);
    }
}
