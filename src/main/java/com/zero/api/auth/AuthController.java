package com.zero.api.auth;

import com.zero.api.auth.pojo.LoginResult;
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
    public LoginResult login(
            @RequestParam(value = "type") String type,
            // type eq mobile
            @RequestParam(value = "mobile", required = false) String mobile,
            @RequestParam(value = "code", required = false) String code) {

        // TODO 登录处理
        LoginResult result = null;
        return result;
    }
}
