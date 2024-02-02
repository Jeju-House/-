package com.jeju.main.domain.room.controller;

import com.jeju.main.domain.room.dto.request.RoomDetailRequest;
import com.jeju.main.domain.room.dto.response.RoomDetailResponse;
import com.jeju.main.domain.room.service.RoomService;
import com.jeju.main.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getRoom(@RequestBody RoomDetailRequest roomDetailRequest){
        RoomDetailResponse roomDetailResponse = roomService.getRoomDetail(roomDetailRequest);
        return SuccessResponse.ok(roomDetailResponse);
    }
}
