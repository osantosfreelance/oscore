package com.osfree.oscore.filter;

import com.osfree.oscore.exception.UnauthenticatedUserException;
import com.osfree.oscore.service.PlatformSecurityContext;
import com.osfree.oscore.service.UserProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author osantos
 *
 */
@Log4j2
@AllArgsConstructor
@Component
public class ValidateSSOUserFilter implements Filter {

	private final PlatformSecurityContext platformSecurityContext;
    private final UserProfileService userProfileService;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
                         throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        final StopWatch task = new StopWatch();
        task.start();

        try {

            if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {

                platformSecurityContext.validateToken();

                // Create Local User Profile for new SSO Users
                val authenticatedUser = platformSecurityContext.loadAuthenticatedUser();

                if (authenticatedUser.getId() == null) {
                    userProfileService.save(authenticatedUser);
                }
                
            }
            
        } catch (final UnauthenticatedUserException exception) {
            log.info("No Authorization found. User Sync will be skipped.");

        } finally {

            log.debug("Proceed to next filter chain...");

            chain.doFilter(request, response);
                
            task.stop();
            
        }

    }
}
