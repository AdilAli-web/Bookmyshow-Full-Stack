public class Demo {
    static int number;
    static
    {
        //number=100;
        System.out.println("static block executed");
    }

    Demo()
    {
        System.out.println("Constructor executed");
    }


    public static void main(String[] args) {
        //Demo d1= new Demo();
        //Demo d2= new Demo();
        System.out.println(number);
    }
}
