public class ExceptionStackTrace {

    public static void main(String[] args) {

        CFS1();
        System.out.println("Main done");
    }

    public static void CFS1()
    {
        CFS2();
    }

    public static void CFS2()
    {
        CFS3();
    }
    public static void CFS3()
    {
        CFS4();
    }
    public static void CFS4()
    {
        System.out.println(10/0);
    }

}
