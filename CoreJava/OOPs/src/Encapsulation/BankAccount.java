package Encapsulation;

public class BankAccount {
    private double balance;

    void deposit(double amount)
    {
        if(amount>0)
        {
            balance=balance+amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
