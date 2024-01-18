package com.jeju.main.domain.guesthouse.dto.response;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import com.jeju.main.domain.guesthouse.domain.Party;
import com.jeju.main.domain.guesthouse.domain.Region;
import com.jeju.main.domain.guesthouse.domain.Review;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestHouseResponseDto {
    private String name;
    private Region region;
    private String promotion;
    private List<Party> parties = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();
    public static GuestHouseResponseDto of(GuestHouse guestHouse) {
        return GuestHouseResponseDto.builder()
                .name(guestHouse.getName())
                .reviews(guestHouse.getReviews())
                .promotion(guestHouse.getPromotion())
                .parties(guestHouse.getParties())
                .reviews(guestHouse.getReviews())
                .build();
    }

}
