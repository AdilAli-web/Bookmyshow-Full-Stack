public class Flow {
    public static void main(String[] args) {

        try {
            System.out.println("Line 1");
            System.out.println(10/0);
            System.out.println("Line 2");
            int arr[]=new int[3];
            arr[5]=10;
        }
       /* catch (ArithmeticException e)
        {
            System.out.println("ArithmeticException Exception handled");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("RuntimeException Exception handled");
        }*/
        catch (Exception e)
        {
            System.out.println("Exception handled");
        }


        System.out.println("Line 3");
    }
}
