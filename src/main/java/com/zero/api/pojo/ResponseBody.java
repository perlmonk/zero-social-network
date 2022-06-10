package com.zero.api.pojo;

/**
 *
 */
public class ResponseBody<T> {
    private final boolean success;
    private final int code;
    private final T data;

    public ResponseBody(boolean success, int code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}
