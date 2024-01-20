package com.jeju.main.domain.user.auth;

import com.jeju.main.domain.user.domain.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfo {
    private Long id;
    private String account;
    private String password;
    private Role role;
    private String gender;
}
