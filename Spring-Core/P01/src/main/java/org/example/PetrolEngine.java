package org.example;

public class PetrolEngine implements Engine {

    public PetrolEngine()
    {
        System.out.println("Petrol Engine Constructor");
    }

    @Override
    public void start() {
        System.out.println("Petrol engine started.");
    }
}
