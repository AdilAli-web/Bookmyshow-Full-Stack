public class Student {

    String name;  //deafult
    int age;
    int marks;

    Student()
    {
        //default
    }

    Student(int age,String name,int marks)
    {
        this.age=age;
        this.name=name;
        this.marks=marks;
    }

   /* Student(int age,String name,int marks)
    {
        this.age=age;
        this.name=name;
        this.marks=marks;
    }*/

    Student(int age,int marks,String name)
    {
        this.age=age;
        this.name=name;
        this.marks=marks;
    }




    Student(int age,String name)
    {
        this.age=age;
        this.name=name;
        this.marks=marks;
    }

    Student(int age)
    {
        this.age=age;
        this.name=name;
        this.marks=marks;
    }
}
