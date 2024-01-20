package com.jeju.main.domain.user.dto.request;

import com.jeju.main.domain.user.domain.Role;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String account;
    private String password;
    private Role role;
    private String gender;
}
