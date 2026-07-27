package SetDemo;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1=(Integer) o1;
        Integer i2=(Integer) o2;

        if(i1<i2) return +1;
        else if(i1>i2) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        TreeSet treeSet= new TreeSet(new MyComparator());
        treeSet.add(10);
        treeSet.add(0);
        treeSet.add(15);
        treeSet.add(64);
        treeSet.add(3);

        System.out.println(treeSet);
    }
}
