import java.util.Scanner;

public class UserInput02 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

       /* System.out.println("Enter name: ");
        String name= sc.next();  //ashwani kumar


        System.out.println("Enter full name: ");
        String name2=sc.nextLine();

        System.out.println(name);
        System.out.println(name2);


        System.out.println();*/


        System.out.println("Enter the Age: ");
        int age=sc.nextInt();
        sc.nextLine(); //left over
        System.out.println("Enter the name: ");
        String name=sc.nextLine();

        System.out.println("Age = "+age);
        System.out.println("name = "+name);
    }
}
