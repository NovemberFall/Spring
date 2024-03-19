package com.example.spring.SpringCore.Inversion_Of_Control.With_IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_IOC {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = context.getBean(MyService.class);
        service.doSomething(); // Spring resolves and injects MyRepository dependency

        MyRepository repository = context.getBean(MyRepository.class);
        repository.getData();
    }
}
