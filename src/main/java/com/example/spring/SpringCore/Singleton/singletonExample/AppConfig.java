package com.example.spring.SpringCore.Singleton.singletonExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// Define a Spring configuration class to create the singleton bean
@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public MySingletonBean mySingletonBean() {
        return new MySingletonBean();
    }
}

