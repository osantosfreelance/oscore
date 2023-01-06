package com.osfree.oscore.service;

import com.osfree.oscore.dto.SystemCodeDTO;
import com.osfree.oscore.entity.UserProfile;

public interface UserProfileService {

    UserProfile save(final UserProfile userProfile);

    UserProfile findByExternalId(final String externalId);

}
