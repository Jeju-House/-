package com.jeju.main.domain.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@RedisHash(value = "refreshToken", timeToLive = 604800000)
public class RefreshToken {
    @Id
    private Long id;
    private String refreshToken;

    public static RefreshToken createRefreshToken(Long userId, String refreshToken) {
        return RefreshToken.builder()
                .id(userId)
                .refreshToken(refreshToken)
                .build();
    }
}

