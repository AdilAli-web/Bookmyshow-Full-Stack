package ThidDemo;

public class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, double salary) {
        this(name,age);
        this.salary = salary;
    }

    void showDetails()
    {
        System.out.println(name+"   "+age+"     "+salary);
    }
}
