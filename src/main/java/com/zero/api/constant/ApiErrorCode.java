package com.zero.api.constant;

/**
 * 业务错误
 */
public enum ApiErrorCode {
    AuthFail(1),
    ;

    private final int value;

    ApiErrorCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
