package com.kd.actua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AConfig {

    @Bean
    public RestTemplate getRest() {
        return new RestTemplate();
    }
}
