package com.jeju.main.domain.user.dto.response;

import com.jeju.main.domain.user.domain.Role;
import com.jeju.main.domain.user.domain.User;
import com.jeju.main.global.config.auth.TokenInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponseDto {
    private Long id;
    private String account;
    private String password;
    private Role role;
    private String gender;
    private String accessToken;
    private String refreshToken;
    private Boolean isFirst;

    public static SignInResponseDto of(User user, TokenInfo token, Boolean isFirst){
        return SignInResponseDto.builder()
                .id(user.getId())
                .account(user.getAccount())
                .gender(user.getGender())
                .role(user.getRole())
                .isFirst(isFirst)
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .build();
    }
}
