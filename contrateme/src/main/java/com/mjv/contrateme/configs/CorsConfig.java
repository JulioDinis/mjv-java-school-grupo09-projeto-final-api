package com.mjv.contrateme.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite CORS para todas as URLs
                .allowedOrigins("http://localhost:8100", "https://contrateme.onrender.com")  // Origem permitida (domínios que podem acessar o backend)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Cabeçalhos permitidos
                .allowCredentials(true);  // Permite envio de cookies e credenciais
    }
}