package com.cfs.SpringBootP06.entity;

import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.SqlTuple;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students=new HashSet<>();

    public Course()
    {

    }

    public Course(String name)
    {
        this.name=name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
