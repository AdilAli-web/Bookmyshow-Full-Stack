package org.example;

public class CarByName {

    private Engine engine;

    public CarByName() {
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
