package com.lalochen.springbootmall.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API")
                        .version("1.0.0")
                        .description("This is a Spring Boot API for managing the E-commerce project backend functions.")
                        .license(new License().name("Live Demo").url("https://frolicking-biscochitos-2d9e1d.netlify.app/")));
    }
}
