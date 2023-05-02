package com.example.spring.SpringCore.BeanLifeCycle.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean() {
        MyBean bean = new MyBean();
        bean.setMessage("Hello, bean life cycle!");
        return bean;
    }
}

