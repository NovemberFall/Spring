package com.example.spring.SpringCore.Singleton.singletonExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Use the singleton bean in a Spring application
public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MySingletonBean bean1 = context.getBean(MySingletonBean.class);
        MySingletonBean bean2 = context.getBean(MySingletonBean.class);

        bean1.setMessage("Hello, Singleton!");
        bean1.showMessage(); // Output: Message: Hello, Singleton!

        bean2.showMessage(); // Output: Message: Hello, Singleton!
        // Since the bean is a singleton, both instances refer to the same object
    }
}
