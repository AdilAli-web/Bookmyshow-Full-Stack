package ThidDemo;

public class Student {

    String name;
    int age;

    Student(String name,int age)
    {
        name=name;
        age=age;
    }

    void showName()
    {
        System.out.println(name);
        System.out.println(age);
        this.print();
    }

    void print()
    {
        System.out.println("hello");
    }
}


