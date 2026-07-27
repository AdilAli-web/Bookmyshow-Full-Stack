package IteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList();
        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }

        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext())
        {
            Integer data=iterator.next();
            System.out.println(data);
            if(data%2==0)
            {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
