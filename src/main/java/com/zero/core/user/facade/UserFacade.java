package com.zero.core.user.facade;

import com.zero.core.user.facade.wrap.UserCombo;
import com.zero.core.user.model.User;
import com.zero.core.user.model.UserProfile;

import java.util.Collection;
import java.util.Map;

public interface UserFacade {

    Map<Long, User> getByIds(Collection<Long> userIds);

    Map<Long, UserProfile> getProfileByIds(Collection<Long> userIds);

    Map<Long, UserCombo> getComboByIds(Collection<Long> userIds);
}
