package ru.relex.internship.relexinternshiptesttask.configurations;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "basicAuth",
        scheme = "basic")
public class SwaggerConfig {
    @Bean
    public OpenAPI relexInternshipTestTask() {
        return new OpenAPI()
                .info(new Info().title("Chat API")
                        .description("Simple RESTful Chat test task Application for Relex autumn internship 2023")
                        .version("v0.0.1"));
    }
}
