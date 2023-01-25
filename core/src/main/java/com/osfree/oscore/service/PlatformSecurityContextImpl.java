package com.osfree.oscore.service;

import com.osfree.oscore.entity.UserProfile;
import com.osfree.oscore.exception.UnauthenticatedUserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.introspection.BadOpaqueTokenException;
import org.springframework.security.oauth2.server.resource.introspection.SpringOpaqueTokenIntrospector;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class PlatformSecurityContextImpl implements PlatformSecurityContext {

    private final SpringOpaqueTokenIntrospector springOpaqueTokenIntrospector;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile loadAuthenticatedUser() {

        UserProfile currentUserProfile = null;
        final SecurityContext context = SecurityContextHolder.getContext();

        if (context != null) {
            final Authentication auth = context.getAuthentication();
            if (auth != null && auth.getPrincipal() != null && auth instanceof JwtAuthenticationToken) {
                val principal = ((Jwt) context.getAuthentication().getPrincipal());
                currentUserProfile = userProfileService.findByExternalId(principal.getSubject());
            }
        }

        if (null == currentUserProfile) {
            log.error("No authenticated user within the platform context!");
            throw new UnauthenticatedUserException();
        }

        return currentUserProfile;
    }

    @Override
    public void validateAccess(final UserProfile userProfile) {

        final UserProfile loginUserProfile = loadAuthenticatedUser();

        if (userProfile.getId() == loginUserProfile.getId()) return;

		/*if (!loginUser.getRole().getCreatableRoles().stream().map(Role::getId).collect(Collectors.toList()).contains(user.getRoleId()))
			throw new InvalidAccessException(loginUser.getUsername());*/
    }

    @Override
    public void validateAccess(final List<Long> roles) {

		/*final UserEntity loginUser = loadAuthenticatedUser();
		if (!loginUser.getRole().getCreatableRoles().stream().map(Role::getId).collect(Collectors.toList()).containsAll(roles)) {
			throw new InvalidAccessException(loginUser.getUsername());
		}*/
    }
}
