package com.javacore.Singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton");
    }

    public static void main(String[] args) {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("Both objects are the same instance of Singleton");
        } else {
            System.out.println("Oops! We have more than one instance of Singleton");
        }

        singleton1.showMessage();// Hello, I am a Singleton
    }
}
