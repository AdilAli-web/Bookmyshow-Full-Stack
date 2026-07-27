package defaultDemo;

import other.DefaultEx;

public class StudentTest {
    public static void main(String[] args) {
        Student s1= new Student();
        System.out.println(s1.name);  //default

        //DefaultEx defaultEx=new DefaultEx();
        Child child=new Child();
        System.out.println(child.name);
        child.show();

    }
}
