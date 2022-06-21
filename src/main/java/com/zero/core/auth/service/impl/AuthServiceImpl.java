package com.zero.core.auth.service.impl;

import com.zero.core.auth.constant.AuthType;
import com.zero.core.auth.service.*;
import org.apache.catalina.mapper.Mapper;

import java.security.AuthProvider;
import java.util.Map;

public class AuthServiceImpl implements AuthService {

    private Map<AuthType, AuthProvider> authProviderMap;
    private OuterIdMapper mapper;

    @Override
    public <P> long authOrCreate(AuthType type, boolean createUser, P param) throws AuthFailException, UserNotFoundException, UserInvalidException, UnsupportedAuthException {
        AuthProvider authProvider = getProvider(type); // or throw UnsupportedAuthException

        Object outerId = authProvider.auth(param); // or throw AuthFailException
        long userId;
        try {
            userId = mapper.get(outerId); // or throw UserNotFoundException
        } catch (UserNotFoundException e) {
            if (!createUser) {
                throw e;
            }
            userId = getNextUserId();
            mapper.set(outerId, userId);
        }

        return userId;
    }
}
