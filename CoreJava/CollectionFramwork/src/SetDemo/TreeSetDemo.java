package SetDemo;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> marks=new TreeSet<>();

        marks.add(80);
        marks.add(50);
        marks.add(90);
        marks.add(70);
        System.out.println(marks);

        Set<String> names=new TreeSet<>();
        names.add("zorawar");
        names.add("babli");
        names.add("aradhya");
        names.add("aqhwani");
        names.add("mushkan");

        System.out.println(names);

        TreeSet<Integer> salaries=new TreeSet<>();
        salaries.add(30000);
        salaries.add(50000);
        salaries.add(70000);
        salaries.add(90000);

        System.out.println(salaries.lower(70000)); //strictly less then x
        System.out.println(salaries.floor(70000)); //less then or equal to x
        System.out.println(salaries.higher(70000)); // strictly greater then x
        System.out.println(salaries.ceiling(70000)); //greater then or equal to x


        TreeSet t= new TreeSet();
        t.add("K");
        t.add("Z");
        t.add("A");
        t.add("A");
        t.add("T");

        System.out.println(t);
    }
}
