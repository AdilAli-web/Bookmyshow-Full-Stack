public class TestAccount {
    public static void main(String[] args) {
        BankAccount account=new BankAccount();
        account.accountHolder="Shreya";
        account.balance=24000;

        account.displayBalance();
    }
}
