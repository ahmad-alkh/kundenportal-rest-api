/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.rest.restkundenportal.config;

import javax.validation.Validator;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

/**
 * @author ahmalk
 *
 * @since 25.07.2021
 *
 */
@Configuration
public class SpringConfig {

    @Autowired
    BuildProperties buildProperties;

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public GroupedOpenApi publicApi() {

        String publicPackagesToScan[] = {"de.intellinet.ausbildung.rest.restkundenportal.controller" //

        };

        return GroupedOpenApi.builder().packagesToScan(publicPackagesToScan) //
                .packagesToExclude() //
                .group("Kundenportal") //
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI().components(new Components() //
                .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))) //
                .addServersItem(new Server().url("/kunden-service")) //
                .addServersItem(new Server().url("")) //
                .info(new Info().title("KUNDENPORTAL API").version(buildProperties.getVersion()));

        return openApi;
    }
}
