package edu.miu.cs.cs489.adsdentalapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ADS Dental Appointments API")
                        .version("v1.0")
                        .description("API documentation for managing patients, dentists, surgeries, appointments, users, and roles in the dental system.")

                );
    }
}
