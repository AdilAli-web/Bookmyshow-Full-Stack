
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the input...");
        int input=sc.nextInt();   //int value

        System.out.println(input);

        System.out.println("Enter the name...");
        String name=sc.next();
        System.out.println("Name is  = "+name);

        //next() -- string

    }
}
