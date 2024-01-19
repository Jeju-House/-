package com.jeju.main.domain.user.dto.response;

import com.jeju.main.domain.user.domain.Role;
import com.jeju.main.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponseDto {
    private Long id;
    private String account;
    private String password;
    private Role role;
    private String gender;

    public static SignUpResponseDto of(User user){
        return SignUpResponseDto.builder()
                .id(user.getId())
                .account(user.getAccount())
                .build();
    }
}
