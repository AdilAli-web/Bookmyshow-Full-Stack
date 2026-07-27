package SetDemo;

import java.util.HashSet;
import java.util.Set;

public class SetP01 {
    public static void main(String[] args) {
        Set<String> emails= new HashSet<>();
        emails.add("ashwani@gmail.com");
        emails.add("aman@gmail.com");
        emails.add("yash@gmail.com");
        emails.add("ashwani@gmail.com");

        System.out.println(emails.size());
        System.out.println(emails);
    }
}
