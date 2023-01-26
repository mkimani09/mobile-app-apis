package com.faidihr.mobile.app.api.util.enums;

public enum EmployeeTerminationStatus {
    ACTIVE(0,"Active"),
    TERMINATED(1,"Terminated");

    private final Integer status;

    private final String action;

    EmployeeTerminationStatus(int status, String action) {
        this.status = status;
        this.action = action;
    }

    public Integer getStatus() {
        return status;
    }
}
