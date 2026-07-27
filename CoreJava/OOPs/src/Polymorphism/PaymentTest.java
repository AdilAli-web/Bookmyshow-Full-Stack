package Polymorphism;

class Payment
{
    void pay()
    {
        System.out.println("Generic Payment");
    }
}

class UpiPayment extends Payment
{
    @Override
    void pay() {
    System.out.println("Payment done using UPI");
}

    void hello()
    {
        System.out.println("Hello everyone");
    }
}


public class PaymentTest {
    public static void main(String[] args) {

        Payment payment= new Payment();
        payment.pay();
        System.out.println("---------------------");

        UpiPayment upiPayment = new UpiPayment();
        upiPayment.pay();
        upiPayment.hello();

        //parent reference can hold child object
        Payment parent=new UpiPayment();
        parent.pay();


    }
}
