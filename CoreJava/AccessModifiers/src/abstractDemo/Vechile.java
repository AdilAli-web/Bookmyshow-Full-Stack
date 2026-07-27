package abstractDemo;
import interfacedemo.Payment;

abstract class Vechile {

    String name;
    int price;
    Vechile()
    {
        System.out.println("Vechicle Con");
    }

    abstract void start();

    void stop()
    {
        System.out.println("Vehicle Stopped");
    }

}

class BMW extends Vechile
{

    @Override
    void start() {
        System.out.println(Payment.a);
    }
}
