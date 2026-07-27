package MapDemo;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Integer,String> map= new TreeMap<>();

        map.put(30,"kafka");
        map.put(10,"Java");
        map.put(4,"JDBC");
        map.put(110,"Spring");

        System.out.println(map);
    }
}
