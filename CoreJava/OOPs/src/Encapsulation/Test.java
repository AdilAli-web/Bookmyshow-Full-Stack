package Encapsulation;

public class Test {

    public static void main(String[] args) {
        BankAccount bankAccount= new BankAccount();

        bankAccount.deposit(5000);

        System.out.println(bankAccount.getBalance());
    }
}
