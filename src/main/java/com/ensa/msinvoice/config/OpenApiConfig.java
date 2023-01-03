package com.ensa.msinvoice.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

/*
!important

spring boot 3.0.1
<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.0</version>
		</dependency>

 */

/*
@OpenAPIDefinition
@Configuration

public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(new Info().title("Product RestAPI Documentation").version("1.0.0").description("Product RestAPI Endpoints Description"));
    }
}
*/