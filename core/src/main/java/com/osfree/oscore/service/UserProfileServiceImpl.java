
package com.osfree.oscore.service;

import com.osfree.oscore.entity.UserProfile;
import com.osfree.oscore.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    @Override
    public UserProfile save(final UserProfile userProfile) {
       return repository.save(userProfile);
    }

    @Override
    public UserProfile findByExternalId(final String externalId) {
        Assert.notNull(externalId, "externalId is a required field");
        val userProfile = repository.findByExternalId(externalId).orElse(null);
        return userProfile;
    }
}
