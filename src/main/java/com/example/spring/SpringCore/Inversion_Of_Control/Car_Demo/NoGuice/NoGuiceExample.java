package com.example.spring.SpringCore.Inversion_Of_Control.Car_Demo.NoGuice;

interface Car {
    int dirve();
}

final class BMW implements Car {
    @Override
    public int dirve() {
        return 80;
    }
}

final class Toyota implements Car {
    @Override
    public int dirve() {
        return 60;
    }
}

final class Owner {
    private final Car car;

    public Owner(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}


public class NoGuiceExample {
    public static void main(String[] args) {
        Owner owner = new Owner(new BMW()); // 手动 new BMW(), 这显然是非常不好的！
        System.out.println("Without guice car can drive at speed = " + owner.getCar().dirve());
    }
}
