import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            List<Integer> nums = new ArrayList<>();
            nums.add(10);
            nums.add(20);
            nums.add(30);
            nums.remove(Integer.valueOf(20));
            System.out.println(nums);


        }
    }
