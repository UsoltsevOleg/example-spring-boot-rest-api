package com.example.boot.starter.config;

import com.example.boot.starter.services.DevSomeServiceImpl;
import com.example.boot.starter.services.SomeService;
import com.example.boot.starter.services.SomeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CustomExampleAutoconfiguration {

    @Bean
    @Profile("!dev")
    public SomeService someService() {
        return new SomeServiceImpl();
    }

    @Bean
    @Profile("dev")
    public SomeService devSomeServiceImpl() {
        return new DevSomeServiceImpl();
    }
}
