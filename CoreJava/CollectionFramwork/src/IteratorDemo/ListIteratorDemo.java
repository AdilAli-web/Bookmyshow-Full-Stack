package IteratorDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("riya");
        list.add("priya");
        list.add("hariya");
        list.add("kariya");

        ListIterator<String> it = list.listIterator();

        System.out.println("---------- FORWARD ----------------");
        while (it.hasNext())
        {
            System.out.println("Current Index : "+it.nextIndex());
            String data = it.next();

            System.out.println("Value : "+data);
            System.out.println("Previous Index : "+it.previousIndex());
            System.out.println();
        }

        System.out.println("-------------- Backward -------------");
        while (it.hasPrevious())
        {
            System.out.println("Current Index : "+it.previousIndex());

            String data=it.previous();
            System.out.println("Value : "+data);
            System.out.println("Next Index : "+it.nextIndex());
            System.out.println();
        }

        System.out.println(list);

        System.out.println("-------------  set element --------------");
        it=list.listIterator();

        while (it.hasNext())
        {
            String data=it.next();

            if(data.equals("priya"))
            {
                it.set("Diya updated");
            }
        }

        System.out.println(list);
    }
}
