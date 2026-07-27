package protectedDemo;

public class Employee {
    protected double salary=5000;

     protected void showSal()
    {

    }
}

class Developer extends Employee
{
    void showSalary()
    {
        System.out.println(salary);
    }
    //inside same class
    //inside same package
    //inside child class in different package
}
