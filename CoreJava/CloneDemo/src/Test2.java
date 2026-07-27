public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {

        Address address= new Address("Delhi");
        Student2 s1= new Student2(101,address);

        Student2 s2=s1.clone();  //clone

        System.out.println(s1.address.city);
        System.out.println(s2.address.city);

        s2.address.city="Pune";
        System.out.println(s1.address.city);
        System.out.println(s2.address.city);


    }
}
