package SetDemo;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> courses= new LinkedHashSet<>();

        courses.add("Java");
        courses.add("Spring boot");
        courses.add("Kafka");
        courses.add("JDBC");

        System.out.println(courses);
    }
}
