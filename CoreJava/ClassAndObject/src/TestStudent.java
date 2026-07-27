public class TestStudent {

    public static void main(String[] args) {
        System.out.println("Hello");

        //we need to create object
        Student s= new Student();
        System.out.println(s.age);
        System.out.println(s.name);

        s.age=22;
        s.name="amit";
        System.out.println(s.age);
        System.out.println(s.name);

        s.study();


        Student s2= new Student();
        System.out.println(s2.name);
        System.out.println(s2.age);

        System.out.println("Name:rahul");
        System.out.println("Age:30");
        System.out.println("Course: Spark 6.0");

    }
}
