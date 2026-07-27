
class StudentPrinter
{
    void printer(Student student)
    {
        System.out.println(student.age);
        System.out.println(student.name);
    }

    Student getInstance()
    {
        Student student=new Student();
        student.name="pooja";
        student.age=50;
        return student;
    }
}



public class PassingObject {

    public static void main(String[] args) {
        Student student=new Student();
        student.name="Akriti";
        student.age=50;

        StudentPrinter std= new StudentPrinter();
        std.printer(student);

       Student s2= std.getInstance();
        System.out.println(s2.name);
    }

}
