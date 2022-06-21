package com.zero.core.auth.service;

import com.zero.core.auth.constant.AuthType;

/**
 *
 */
public interface AuthService {

    default <P> long authOnly(AuthType type, boolean createUser, P param)
            throws AuthFailException, UserNotFoundException, UserInvalidException {
        return authOrCreate(type, false, param);
    }

    /**
     * 登录鉴定
     * @param type 类型
     * @param createUser 如果没有对应的用户，创建
     * @param param 类型对应的参数
     * @return
     * @param <P> 参数的类型
     * @throws AuthFailException param验证失败
     * @throws UserNotFoundException 当 createUser = false 且不存在对应的用户时抛出
     * @throws UserInvalidException 用户不可登录（如封禁）
     */
    <P> long authOrCreate(AuthType type, boolean createUser, P param)
            throws AuthFailException, UserNotFoundException, UserInvalidException, UnsupportedAuthException;
}
