package ListDemo;

import java.util.ArrayList;
import java.util.List;

public class ListP02 {
    public static void main(String[] args) {

        List<String> students = new ArrayList<>();
        students.add("Aman");
        students.add("Riya");
        students.add("karam");

        students.add(1,"Neha");
        System.out.println(students);

        System.out.println(students.get(2));

        students.set(2,"Rahul");
        students.remove("Aman");

        System.out.println(students);
    }
}
