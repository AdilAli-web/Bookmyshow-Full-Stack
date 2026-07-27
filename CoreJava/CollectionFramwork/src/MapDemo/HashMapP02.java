package MapDemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapP02 {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(101,"Rahul");
        map.put(102,"Amit");
        map.put(103,"Neha");

        for(Map.Entry<Integer,String > entry:map.entrySet())
        {
            System.out.println("Key : "+entry.getKey());
            System.out.println("Value : "+entry.getValue());
        }

        System.out.println("---------- only keys -----------");

        System.out.println(map.get(101));

        for(Integer key: map.keySet())
        {
            System.out.println(key+ "---> "+map.get(key));

        }

        map.forEach((k,v)->{
            System.out.println("key "+k + " value "+v);
        });


        if(!map.containsKey(103))
        {
            map.put(104,"Hariya");
        }

        map.computeIfAbsent(105,k->"Hira");

        System.out.println(map);
    }
}
