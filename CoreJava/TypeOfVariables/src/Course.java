public class Course {

   String name="Spark 6.0";
   static String instName="CFS";

    public static void main(String[] args) {

        System.out.println(instName);
        System.out.println(new Course().instName);

        //print();
        //1. make print static
        //2. use object reference

    }

    void print()
    {
        System.out.println(name);
        System.out.println(instName);
    }

    void m1()
    {
        print();
    }

    static void display()
    {
        System.out.println(instName);
    }
}
