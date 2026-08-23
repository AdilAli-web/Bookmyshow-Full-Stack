package org.example;

public class DieselEngine implements Engine{

    public DieselEngine()
    {
        System.out.println("Diesel engine initialized.");
    }

    @Override
    public void start() {
        System.out.println("Diesel Engine started");
    }
}
