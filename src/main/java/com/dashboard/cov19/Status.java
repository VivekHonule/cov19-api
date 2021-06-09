package com.dashboard.cov19;

public class Status {
    private final StatusType type;
    private final String message;

    public Status(StatusType type, String message) {
        this.type = type;
        this.message = message;
    }
}
