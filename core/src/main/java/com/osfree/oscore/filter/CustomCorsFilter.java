package com.osfree.oscore.filter;

import com.osfree.oscore.property.ServerSecurityPropertyConfig;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class CustomCorsFilter implements Filter {

	private final ServerSecurityPropertyConfig securityPropertyConfig;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) 
                         throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        final StopWatch task = new StopWatch();
        task.start();

        try {

            // Allow CORS againts the Platform API
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Origin", securityPropertyConfig.getAllowedOrigin());
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            
            final String reqHead = request.getHeader("Access-Control-Request-Headers");

            if (null != reqHead && !reqHead.isEmpty()) {
                response.setHeader("Access-Control-Allow-Headers", reqHead);
            }

            if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {

                log.debug("Proceed to next filter chain...");
                
                chain.doFilter(request, response);
                
            }
            
        } finally {
                
            task.stop();
            
        }

    }
    
}
