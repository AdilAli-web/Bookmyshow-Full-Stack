import java.util.Scanner;

public class UserInput03 {

    public static void main(String[] args) {
            //take student marks in input

        Scanner sc= new Scanner(System.in);
        int[] marks=new int[5];
        for(int i=0;i<marks.length;i++)
        {
            System.out.println("Enter the marks for Student "+(i+1)+" : ");
            marks[i]=sc.nextInt();
        }
        System.out.println("Entered Marks: ");
        for(int mark:marks)
        {
            System.out.println(mark);
        }
        sc.close();
    }
}
