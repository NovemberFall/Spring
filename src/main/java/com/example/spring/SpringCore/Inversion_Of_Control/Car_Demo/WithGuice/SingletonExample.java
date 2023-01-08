package com.example.spring.SpringCore.Inversion_Of_Control.Car_Demo.WithGuice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.inject.Inject;

interface Car {
    int dirve();
}

// 方法一: 直接加入到implementation class, e.g. cache, db connection
@Singleton
final class BMW implements Car {

    /*
     由于这个 BMW() 没有dependency, 把BMW()放回hashmap里，
            hashmap的`key`是 BMW() 的class, `value`是 BMW()的instance
     */
    @Inject
    BMW(){} // 此时，BMW 加入到 HashMap 里

    @Override
    public int dirve() {
        return 80;
    }

    public static BMW create() {
        //比如是第三方factory提供的method
        return new BMW();
    }
}

final class Owner {
    private final Car car;

    /*
     @Inject 做两件事：
        第一： 如果我们的constructor 里有dependency, 它会自动帮我们填充
        第二： 生成好的object, 放回到 HashMap 里。
     */
    @Inject // 注意 inject 一般是配合 constructor 一起使用，其他场景不建议!
    public Owner(Car car) { // 在owner这里，从HashMap 里取出来 BMW
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}

final class CarModule extends AbstractModule {

    @Override
    protected void configure() {
        // 方法一： bind 时候加
//        bind(Car.class).to(BMW.class);
        //bind Car's interface to the concrete implementation of BMW

//        bind(Car.class).toInstance(BMW.create()); // Instance 默认singleton
    }


    //方法三， use Provides annotation
    @Provides // provide 和 inject 做同样的事情，但是它可以使用在任何method 的场景, 它把return的东西，放到HashMap里
    Car provideCar() {
        return BMW.create();
    }
}


public class SingletonExample {
    public static void main(String[] args) {
        // 这里的injector就是guice的hashmap
        Injector injector = Guice.createInjector(new CarModule());
        Owner owner = injector.getInstance(Owner.class); // getInstance() 相当于 getKey()
        System.out.println("Without guice car can drive at speed = " + owner.getCar().dirve());
    }
}