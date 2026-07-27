package CustomException;

public class ProductNotFoundException extends  RuntimeException {

    ProductNotFoundException(String msg)
    {
        super(msg);
    }
}
