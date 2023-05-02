package com.example.spring.SpringCore.BeanLifeCycle.example;

public class MyBean {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("Initializing bean with message: " + message);
    }

    public void destroy() {
        System.out.println("Destroying bean");
    }

    public void showMessage() {
        System.out.println("Message: " + message);
    }
}

