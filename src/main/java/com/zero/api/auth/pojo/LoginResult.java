package com.zero.api.auth.pojo;

/**
 *
 */
public class LoginResult {
    private final String uid;
    private final String ticket;

    public LoginResult(String uid, String ticket) {
        this.uid = uid;
        this.ticket = ticket;
    }

    public String getUid() {
        return uid;
    }

    public String getTicket() {
        return ticket;
    }
}
