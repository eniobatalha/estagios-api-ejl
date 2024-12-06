package com.taesii.estagio_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EstagioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstagioApiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Permite todas as rotas
						.allowedOrigins("http://localhost:3000") // Permite requisições do frontend no localhost:3000
						.allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE") // Métodos HTTP permitidos
						.allowedHeaders("*") // Permite todos os cabeçalhos
						.allowCredentials(true); // Permite envio de cookies/sessões
			}
		};
	}

}
