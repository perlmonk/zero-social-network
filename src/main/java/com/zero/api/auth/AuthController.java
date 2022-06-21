package com.zero.api.auth;

import com.zero.api.annotation.Exception2Code;
import com.zero.api.annotation.TicketAware;
import com.zero.api.annotation.Uid;
import com.zero.api.auth.pojo.LoginResult;
import com.zero.api.constant.ApiErrorCode;
import com.zero.core.auth.constant.AuthType;
import com.zero.core.auth.service.*;
import com.zero.core.auth.service.pojo.MobileParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 鉴权接口
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录或者注册
     *
     * @param type
     * @param mobile mobile
     * @return
     */
    @GetMapping("/login")
    @Exception2Code(exception = AuthFailException.class, code = ApiErrorCode.AuthFail)
    public LoginResult login(
            @RequestParam(value = "type") String type,
            // type eq mobile
            @RequestParam(value = "mobile", required = false) String mobile,
            @RequestParam(value = "code", required = false) String code)
            throws AuthFailException, UnsupportedAuthException {

        AuthType authType = AuthType.fromValue(type);
        if (authType == null) {
            throw new UnsupportedAuthException();
        }
        Object param = null;
        switch (authType) {
            case Mobile:
                param = new MobileParam(mobile, code);
                break;
            default:
                throw new UnsupportedAuthException();
        }

        try {
            long userId = authService.authOrCreate(authType, true, param);

            String ticket = ticketService.create(userId);
            String uid = null;
            return new LoginResult(uid, ticket);
        } catch (UserNotFoundException ignore) {
            // 不会发生的异常，TODO log和监控
            throw new AuthFailException(ignore);
        }
    }

    @TicketAware(loginRequired = false)
    public Object test(@Uid Long uid) {

    }
}
