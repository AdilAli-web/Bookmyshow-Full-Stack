package org.example;

public class CarByConstructor {

    private Engine engine;

    public CarByConstructor() {
        System.out.println("CarByName Constructor");
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive()
    {
        System.out.println("Autowiring byName");
        engine.start();
        System.out.println("Car is running");
    }
}
