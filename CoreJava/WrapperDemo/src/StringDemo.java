public class StringDemo {
    public static void main(String[] args) {

        String ageText="21";
        int age=Integer.parseInt(ageText);

        System.out.println(age);

        //creating object
        Integer num=new Integer(10);

        Integer n1=100;
        Integer number=Integer.valueOf(n1);

        Integer n2=100;
        Double price=99.50;
        Character grade='A';
        Boolean active=true;

        System.out.println(n2);
        System.out.println(price);
        System.out.println(grade);
        System.out.println(active);
    }
}
