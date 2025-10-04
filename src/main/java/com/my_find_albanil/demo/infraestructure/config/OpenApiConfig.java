package com.my_find_albanil.demo.infraestructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Servidor local de desarrollo");
        
        Contact contact = new Contact();
        contact.setName("Find My Albañil Team");
        contact.setEmail("contact@findmyalbanil.com");
        
        License license = new License()
            .name("MIT License")
            .url("https://opensource.org/licenses/MIT");
        
        Info info = new Info()
            .title("Find My Albañil API")
            .version("1.0.0")
            .description("API REST para la plataforma Find My Albañil - Conectando trabajadores con empleadores")
            .contact(contact)
            .license(license);
        
        return new OpenAPI()
            .info(info)
            .servers(List.of(localServer));
    }
}
