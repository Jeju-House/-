package com.jeju.main.domain.user.dto.request;

import lombok.Getter;

@Getter
public class SignInRequestDto {
    private String account;
    private String password;
}
