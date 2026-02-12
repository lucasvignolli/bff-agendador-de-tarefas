package com.example.lucasvignolli.bffagendadordetarefas.infrastructure.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CorsConfig {

    //Com essa anotação o Spring executa mesmo sem chamarmos o método.
    @Bean

    public WebMvcConfigurer configCors(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") //Porta que será usada pelo FrontEnd (pode variar).
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                        .allowedHeaders("*")
                        .allowCredentials(true) //importante (token)
                        .maxAge(360); //Tempo padrão
                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }
}

