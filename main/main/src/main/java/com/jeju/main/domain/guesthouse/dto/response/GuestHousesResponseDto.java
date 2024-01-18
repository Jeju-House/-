package com.jeju.main.domain.guesthouse.dto.response;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GuestHousesResponseDto {
    private List<GuestHouseResponseDto> guestHouseResponseDtoList;
    private GuestHousesResponseDto guestHousesResponseDto;
    public static List<GuestHouseResponseDto> mapToResponseDtoList(List<GuestHouse> guestHouseList) {
        return guestHouseList.stream()
                .map(GuestHouseResponseDto::of)
                .collect(Collectors.toList());
    }

}
