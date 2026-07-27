public class StudentTest {
    public static void main(String[] args) {
       /* Student s1= new Student(10,"raj,32");
        s1.age=10;
        s1.name="Raj";
        s1.marks=32;

        System.out.println(s1.name);

        Student s2= new Student();
        s2.age=12;
        s2.name="Ravi";
        s2.marks=42;
        Student s3= new Student();
        Student s4= new Student();
        Student s6= new Student();
        Student s7= new Student();
        Student s8= new Student();
        Student s9= new Student();*/

        Student s1= new Student(10,"ravi",33);
        System.out.println(s1.age);

        Student s2= new Student();
        System.out.println(s2.name);
        System.out.println(s2.age);

        Student s3= new Student(10,"rahul");
        Student s4= new Student(33);

        Student s5= new Student(10,3,"ree");


    }
}
