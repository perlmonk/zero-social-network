package com.zero.api.auth;

import com.zero.api.annotation.Exception2Code;
import com.zero.api.annotation.TicketAware;
import com.zero.api.annotation.Uid;
import com.zero.api.auth.pojo.LoginResult;
import com.zero.api.constant.ApiErrorCode;
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
            throws AuthFailException {

        // TODO 登录处理
        LoginResult result = null;
        return result;
    }

    @TicketAware(loginRequired = false)
    public Object test(@Uid Long uid) {

    }
}
