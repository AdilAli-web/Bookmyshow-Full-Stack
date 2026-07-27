package Abstraction;

public class Test {
    public static void main(String[] args) {
        Vehicle v1= new Bike();
        Vehicle v2= new Car();
        v1.start();
        v2.start();

    }
}
