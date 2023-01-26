package com.faidihr.mobile.app.api.util.enums;

public enum UserStatus {
    ACTIVE(1,"Active"),
    BLOCKED(2,"Blocked");

    private final int status;

    private final String description;

    UserStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }


    public Integer getStatus() {
        return status;
    }
}
