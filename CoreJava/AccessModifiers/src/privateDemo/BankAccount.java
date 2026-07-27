package privateDemo;

public class BankAccount {

    private double balance;

    void deposit(double amount)
    {
        if(amount>0)
        {
            balance=balance+amount;
        }
    }

    double getBalance()
    {
        helloForUser();
        return balance;
    }

    private void helloForUser()
    {
        System.out.println("Hello sir....");
    }
}

class Child extends BankAccount
{
    /*double getBal()
    {
        //return balance;
        r
    }*/
}