package com.rpe.card.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "App Card",
        version = "v1",
        description = """
                Service to handle card operations.
                """))
public class OpenApiConfig {
}
