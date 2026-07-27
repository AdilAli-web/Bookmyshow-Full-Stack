package CustomException;

public class InsufficentBalanceException extends Exception{

    InsufficentBalanceException(String msg)
    {
        super(msg);
    }
}
