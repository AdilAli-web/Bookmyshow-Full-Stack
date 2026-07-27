import java.util.ArrayList;

public class ArrayListDem {
    public static void main(String[] args) {

        ArrayList<Integer> nums=new ArrayList<>();

        //Autoboxing
        nums.add(10);
        nums.add(20);

        System.out.println(nums);

        Integer a=10;

        //Unboxing
        Integer obj=Integer.valueOf(100);
        int num=obj.intValue();

        System.out.println(num);


        Integer o1=100;
        int a1=o1; //
        System.out.println(a1);
    }
}
