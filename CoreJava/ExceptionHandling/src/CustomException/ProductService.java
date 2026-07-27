package CustomException;

public class ProductService {
    void findProduct(int productId)
    {
        if(productId!=101)
        {
            //exception
            throw new ProductNotFoundException("Product not found");
        }
        System.out.println("Product found");
    }
}
