/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
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
import org.springframework.security.oauth2.server.resource.introspection.SpringOpaqueTokenIntrospector;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OlieSantos
 *
 */
@Log4j2
@RequiredArgsConstructor
public abstract class PlatformSecurityContextImpl implements PlatformSecurityContext {

	private final UserProfileService userProfileService;

	@Override
	public UserProfile loadAuthenticatedUser() {

		UserProfile currentUserProfile = null;
        final SecurityContext context = SecurityContextHolder.getContext();

        if (context != null) {
            final Authentication auth = context.getAuthentication();
            if (auth != null && auth.getPrincipal() != null) {
				val principal = ((Jwt)context.getAuthentication().getPrincipal());
				currentUserProfile = userProfileService.findByExternalId(principal.getSubject());

				if (currentUserProfile == null) {
					currentUserProfile = UserProfile.builder()
							.externalId(principal.getSubject())
							.firstName(principal.getClaim("given_name"))
							.lastName(principal.getClaim("family_name"))
							.build();
				}
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
