package ListDemo;

import java.util.Stack;

public class StackP01 {
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s);
        System.out.println(s.indexOf("B"));
        System.out.println(s.peek());
    }
}
