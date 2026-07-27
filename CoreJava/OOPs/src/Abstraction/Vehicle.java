package Abstraction;

abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle{

    @Override
    void start() {
        System.out.println("Car start with key");
    }
}

class Bike extends Vehicle
{
    @Override
    void start() {
        System.out.println("Bike start with self button");
    }
}