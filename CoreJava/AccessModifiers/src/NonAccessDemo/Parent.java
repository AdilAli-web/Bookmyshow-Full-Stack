package NonAccessDemo;

public class Parent {

    final void show()
    {
        System.out.println("Parent method");
    }
}

class Child extends  Parent
{
    //not possible
    /*void show()
    {
        System.out.println("child method");
    }*/
}
