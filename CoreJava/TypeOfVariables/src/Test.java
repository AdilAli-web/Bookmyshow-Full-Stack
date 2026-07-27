public class Test {

    public static void main(String[] args) {
        Student s1= new Student();
        Student s2= new Student();

        s1.name="Rahul";
        s2.name="Priya";

        System.out.println(s1.name);
        System.out.println(s2.name);
        //System.out.println(s1.instName);
        //System.out.println(s2.instName);
        System.out.println(Student.instName);

        //s1.instName="Genie Academy";
        Student.instName="Genie Academy"; //best practise i know but why ?



        System.out.println("---------------------------------------");

        s1.name="hariya";
        System.out.println(s1.name);
        System.out.println(s2.name);

        System.out.println("s1 instName "+s1.instName);
        System.out.println("s2 instName  "+s2.instName);

    }
}
