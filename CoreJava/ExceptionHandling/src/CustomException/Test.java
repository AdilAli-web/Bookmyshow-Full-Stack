package CustomException;

public class Test {
    public static void main(String[] args) {
        ProductService service= new ProductService();

        try {
            service.findProduct(300);
        }
        catch (ProductNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
