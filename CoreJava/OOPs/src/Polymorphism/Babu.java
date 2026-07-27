package Polymorphism;


class Calculator
{
    public  int add(int a, int b)
    {
        return a+b;
    }

    public  int add(int a, int b,int c)
    {
        return a+b+c;
    }

    public  double add(double a, double b)
    {
        return a+b;
    }
}


public class Babu {

    public void khanaKhaya(String msg)
    {
        System.out.println(msg);
    }

    public void khanaKhaya(String name, String msg)
    {
        System.out.println(msg);
    }

   public void khanaKhaya(String name, String msg, String add)
    {
        System.out.println(msg);
    }
}
