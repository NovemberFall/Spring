package com.example.spring.SpringCore.Inversion_Of_Control.Without_IOC;

public class MyService {
    private MyRepository repository;

    public MyService() {
        this.repository = new MyRepository();
        // Manually creating an instance of MyRepository
    }

    public void doSomething() {
        // Using methods from MyRepository
        repository.getData();
    }
}

