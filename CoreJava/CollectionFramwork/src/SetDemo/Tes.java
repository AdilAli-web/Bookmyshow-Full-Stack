package SetDemo;

import java.util.TreeSet;

public class Tes {
    public static void main(String[] args) {
        TreeSet<Student> students= new TreeSet<>();

        System.out.println("Adding Rahul");
        students.add(new Student(10,"Rahul"));

        System.out.println("Adding Amit");
        students.add(new Student(5,"Amit"));

        System.out.println("Adding Neha");
        students.add(new Student(20,"Neha"));

        System.out.println("Adding Riya");
        students.add(new Student(15,"Riya"));

        System.out.println(students);
    }
}
