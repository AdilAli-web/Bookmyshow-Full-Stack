package ListDemo;

import java.util.Vector;

public class VectorP01 {
    public static void main(String[] args) {
        Vector v=new Vector();

        System.out.println(v.capacity());

        for (int i = 1; i <=10 ; i++) {
            v.addElement(i);
        }
        System.out.println(v.capacity());
        v.addElement("A");
        System.out.println(v.capacity());
        System.out.println(v);
    }
}
