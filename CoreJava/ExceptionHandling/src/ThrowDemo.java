import java.util.Scanner;

public class ThrowDemo {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter age: ");
        int age=sc.nextInt();

        if(age<18)
        {
            try {
                System.out.println("inside try");
                throw new ArithmeticException("Age is must be 18 or above");
            }
            catch (ArithmeticException e)
            {
                System.out.println("Catch block");
            }
        }
        System.out.println("Allowed to pub");
    }
}
