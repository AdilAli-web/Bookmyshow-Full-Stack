package SetDemo;

import java.util.SortedSet;

public class Student implements Comparable<Student>{

    int id;
    String name;

    Student(int id,String name)
    {
        this.id=id;
        this.name=name;
    }


    @Override
    public int compareTo(Student o) {
        System.out.println("Comparing "+this.id + " with "+o.id);
        return Integer.compare(this.id,o.id);
    }

    @Override
    public String toString() {
        return id+"_"+name;
    }
}
