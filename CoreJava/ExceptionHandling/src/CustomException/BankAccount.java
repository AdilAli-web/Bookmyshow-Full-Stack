package CustomException;

public class BankAccount {
    double balance=5000;

    /*void withdraw(double amount)
    {
        if(amount>balance)
        {
           try {
               throw new InsufficentBalanceException("Not enough amount");
           }
           catch (InsufficentBalanceException e)
           {
               System.out.println("You have balance lower then : "+amount);
           }
           finally {
               System.out.println("Transaction close");
           }
        }
        else
        {
            System.out.println("Withdraw successful");
        }
        balance=balance-amount;


    }*/


    void withdraw(double amount) throws InsufficentBalanceException {
        if(amount>balance)
        {
            throw new InsufficentBalanceException("Not enough amount");
        }

        System.out.println("Withdraw successful");


    }
}
