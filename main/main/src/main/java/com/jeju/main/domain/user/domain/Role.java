package com.jeju.main.domain.user.domain;

import java.util.Arrays;

public enum Role {
    ADMIN("admin"),
    NORMAL("user");
    private final String permission;
    Role(String permission){
        this.permission = permission;
    }
    public static Role getRole(String permissionType){
        return Arrays.stream(values())
                .filter(Role -> Role.permission.equals(permissionType))
                .findFirst()
                .orElseThrow(null);
    }
}
