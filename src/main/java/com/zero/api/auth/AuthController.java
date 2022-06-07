package com.zero.api.auth;

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
     * @param name
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
