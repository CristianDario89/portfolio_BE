package com.abmlAPI.Portfolio;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
         SpringApplication.run(PortfolioApplication.class, args);
                  System.out.println("holaa funcionando");
         } 
        
        @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api").allowedOrigins("/**").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
        
}

/*
 /*
      @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api").allowedOrigins("http://localhost:4200");
			}
		};
	}
    */