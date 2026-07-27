public class FinallyDemo {
    public static void main(String[] args) {

        try
        {
            int res=10/2;
            System.out.println(res);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Exception handle");
        }
        finally {
            System.out.println("finally block executed");
        }

        System.out.println("Program done");
    }
}
