public class Question1 {

    static int test()
    {
        try {

            System.out.println("try");
            //int r=10/0;
            return 10;
        }
        catch (Exception e)
        {
            System.out.println("catch");
            return 20;
        }
        finally {
            System.out.println("finally");
            return 30;
        }

        //return 40; //unreachable code
    }

    public static void main(String[] args) {
      int res=test();
        System.out.println("Result : "+res);
    }


}
