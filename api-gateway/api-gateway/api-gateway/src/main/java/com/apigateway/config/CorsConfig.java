package com.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig{

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
            }
        };
    }
	@Bean
	  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
	    http.csrf(ServerHttpSecurity.CsrfSpec::disable);
		http.cors()
			.and()
			.csrf(ServerHttpSecurity.CsrfSpec::disable);
	    return http.build();
	  }
}
