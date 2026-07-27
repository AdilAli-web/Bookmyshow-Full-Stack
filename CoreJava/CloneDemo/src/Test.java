public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

       Student s1= new Student(101,"rahul");

       Student s2= (Student) s1.clone();
        System.out.println(s1.id + " "+s1.name);
        System.out.println(s2.id + " "+s2.name);
        System.out.println(s1==s2);
    }
}
