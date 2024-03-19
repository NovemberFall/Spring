package com.example.spring.SpringCore.Inversion_Of_Control.With_IOC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService(createMyRepository());
        // Inject MyRepository bean into MyService
    }

    @Bean
    public MyRepository createMyRepository() {
        return new MyRepository();
    }
}
