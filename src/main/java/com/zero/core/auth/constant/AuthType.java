package com.zero.core.auth.constant;

public enum AuthType {
    Mobile("mobile"),
    ;

    private final String value;

    AuthType(String value) {
        this.value = value;
    }

    public static AuthType fromValue(String value) {

    }
}
