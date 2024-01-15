package com.example.postgresql.config;

import com.jwt.token.generator.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("${jwt-token-expirationInMillis}")
    private long token_expirationInMillis;
    @Bean
    public JwtTokenGenerator jwtTokenGenerator() {
        return new JwtTokenGenerator(jwtSecret,token_expirationInMillis);
    }
}
