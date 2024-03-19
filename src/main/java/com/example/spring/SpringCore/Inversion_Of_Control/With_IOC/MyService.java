package com.example.spring.SpringCore.Inversion_Of_Control.With_IOC;

public class MyService {
    private MyRepository repository;

    // Constructor injection
    public MyService(MyRepository repository) {
        this.repository = repository;
        // Dependency injected by Spring IoC container
    }

    public void doSomething() {
        // Using methods from MyRepository
        repository.getData();
    }
}
