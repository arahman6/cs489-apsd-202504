package edu.miu.cs.cs489.adsdentalapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ADS Dental Appointments API")
                        .version("v1.0")
                        .description("API documentation for managing patients, dentists, surgeries, appointments, users, and roles in the dental system.")
                        .contact(new Contact()
                                .name("Arif Rahman")
                                .email("mdarif.rahman@miu.edu")
                                .url("https://github.com/arahman6")
                        ))
                // Add tags configuration here
                .tags(List.of(
                        new Tag().name("Patients").description("Manage patient records and information"),
                        new Tag().name("Dentists").description("Handle dentist profiles and schedules"),
                        new Tag().name("Surgeries").description("Manage dental surgery locations and facilities"),
                        new Tag().name("Appointments").description("Schedule and track dental appointments"),
                        new Tag().name("Users").description("User account management"),
                        new Tag().name("Roles").description("Role-based access control management")
                ));
    }
}