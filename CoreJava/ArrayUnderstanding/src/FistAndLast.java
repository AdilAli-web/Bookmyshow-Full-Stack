import java.util.Arrays;

public class FistAndLast {
    public static void main(String[] args) {
        int arr[]={80,90,12,134,13,44};

        //find first
        System.out.println("first element = "+arr[0]);
        System.out.println("last element = "+arr[arr.length-1]);

        int nums[]=new int[3];
        System.out.println(nums[0]);


        for(int i=0;i<nums.length;i++)
        {
            nums[i]=i;
        }
        System.out.println(Arrays.toString(nums));
    }
}
