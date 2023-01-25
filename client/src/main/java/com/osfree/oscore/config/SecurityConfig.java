package com.osfree.oscore.config;


import com.osfree.oscore.property.ServerSecurityPropertyConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ServerSecurityPropertyConfig securityPropertyConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf(CsrfConfigurer::disable)
                .sessionManagement(SessionManagementConfigurer::disable)
                .oauth2Login()
                .and()
                .authorizeRequests(auth ->
                        auth.antMatchers(securityPropertyConfig.getIgnoringArray())
                                .permitAll()
                                .anyRequest()
                                .authenticated());
        return http.build();
    }

}
