package ThidDemo;

class CFS
{
    String name="CodeForSuccess.in";
    CFS()
    {
        System.out.println("CFS Default constructor....");
    }
}


class Course extends CFS
{
    String name="Spark 6.0";
    Course()
    {
        //super()
        System.out.println("Course Default constructor....");
    }

    Course(String name)
    {
        //super()
        this();
        System.out.println("Parameterized constructor");
    }

    void showName()
    {
        System.out.println(name); //cureent class
        System.out.println(this.name); //cureent class
        System.out.println(super.name); //parent class
    }
}


public class CourseTest {

    public static void main(String[] args) {
        Course course= new Course("Spark 6.0: java full stack");

    }
}
