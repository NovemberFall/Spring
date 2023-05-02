package com.example.spring.SpringCore.BeanLifeCycle.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean bean = context.getBean(MyBean.class);
        bean.showMessage(); // Output: Message: Hello, bean life cycle!
        ((ConfigurableApplicationContext) context).close(); // close the context to destroy the bean
    }
}

