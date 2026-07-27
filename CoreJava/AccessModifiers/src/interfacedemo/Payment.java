package interfacedemo;

public interface Payment {
    int a = 10;
    void pay();
    //void show();
    //object of interface not possible
    //new Student() ---> instance variable
}


class UPIPayment implements Payment
{
    @Override
    public void pay() {
        System.out.println("Payment done by UPI");
    }
}


class CardPayment implements Payment
{
    @Override
    public void pay() {
        System.out.println("Payment done by Card");
    }
}

