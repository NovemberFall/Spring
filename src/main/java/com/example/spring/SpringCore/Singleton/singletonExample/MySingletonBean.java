package com.example.spring.SpringCore.Singleton.singletonExample;

// Define a class to be used as a singleton bean
public class MySingletonBean {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println("Message: " + message);
    }
}

