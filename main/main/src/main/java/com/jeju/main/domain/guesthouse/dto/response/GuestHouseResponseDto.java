package com.jeju.main.domain.guesthouse.dto.response;

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

}
