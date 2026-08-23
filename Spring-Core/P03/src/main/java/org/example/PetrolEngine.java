package org.example;

public class PetrolEngine implements IEngine{


    public PetrolEngine() {
        System.out.println("Petrol Engine Constructor");
    }

    @Override
    public void start() {
        System.out.println("petrol engine started");
    }
}
