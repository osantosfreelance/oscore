package com.osfree.oscore.config;

import com.osfree.oscore.property.ServerSecurityPropertyConfig;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Access API Documentation from browser using below link:
 * 
 * http://<hostname>/swagger-ui.html#
 * 
 * @author JunMinon
 * @author osantos
 *
 */
@Configuration
@ConfigurationProperties(prefix = "swagger")
@RequiredArgsConstructor
public class SwaggerConfig {

	private final ServerSecurityPropertyConfig securityPropertyConfig;

    private String title;
    private String description;
    private String version;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(title)
                        .description(description)
                        .version(version)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
