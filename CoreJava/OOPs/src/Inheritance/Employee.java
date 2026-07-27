package Inheritance;

public class Employee {

    Employee()
    {
        //super() ---> Object
        System.out.println("---------Emp-------------");
        System.out.println("Employee Constructor...");
    }

    int id;
    String name;
    double salary;
}


class Developer extends Employee
{
    String progLang;
}

class Manager extends Employee
{
    //deafult
    Manager()
    {
        //super(); //parent constructor call
        System.out.println("----------Manager------------");
        System.out.println("Manager constructor....");
    }
    int teamSize=100;
}


class Chor
{
    int a=10;
}