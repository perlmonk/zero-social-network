package com.zero.core.user.service;

import com.zero.core.user.model.User;
import com.zero.core.user.model.UserSetting;

import java.util.Collection;
import java.util.Map;

/**
 *
 */
public interface UserService {

    Map<Long, User> getByIds(Collection<Long> userIds);

    <M> long createUser(M meta);
}
