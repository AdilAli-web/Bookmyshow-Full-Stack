package org.example;

public class Car {

    private Engine engine;

    public Car()
    {
        System.out.println("Car Class Constructor");
    }

    public Car(Engine engine) {
        System.out.println("Engine set via Constructor");
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        System.out.println("Engine set via setter injection");
        this.engine = engine;
    }

    public void drive()
    {
        engine.start();
        System.out.println("Car is running....");
    }
}
