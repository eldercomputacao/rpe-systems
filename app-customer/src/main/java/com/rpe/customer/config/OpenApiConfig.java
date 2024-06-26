package com.rpe.customer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "App Customer",
        version = "v1",
        description = """
                Service to handle customer operations.
                """))
public class OpenApiConfig {
}
