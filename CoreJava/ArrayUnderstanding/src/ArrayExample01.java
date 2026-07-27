import java.util.Arrays;

class Student
{
    int a=10;
}

public class ArrayExample01 {

    public static void main(String[] args) {
        int arr[]=new int[5];
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;

        //for each loop
        for(int data:arr)
        {
            System.out.println(data);
        }

        //
        System.out.println(Arrays.toString(arr));

        int[] nums={10,20,40,50,60};
        System.out.println(nums.length);

        for(int i=0;i<=nums.length;i++)
        {
            System.out.println(nums[i]);
        }

    }
}
