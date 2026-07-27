package ListDemo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartExm {
    public static void main(String[] args) {
        List<CardItem> cart= new ArrayList<>();

        cart.add(new CardItem(101,"keyboard",1,2500));
        cart.add(new CardItem(102,"Mouse",2,800));
        cart.add(new CardItem(103,"Monitor",1,1500));

        double total=cart.stream()
                .mapToDouble(item->item.quantity() % item.price())
                .sum();

        System.out.println("cart : "+cart);
        System.out.println("Total: "+total);
    }
}
