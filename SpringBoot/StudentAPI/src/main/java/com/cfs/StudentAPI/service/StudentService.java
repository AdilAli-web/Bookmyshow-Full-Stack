package com.cfs.StudentAPI.service;

import com.cfs.StudentAPI.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList=new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(101,"Priya",88));
        studentList.add(new Student(102,"hariya",33));


    }


    public List<Student> getAllStudents()
    {
        return studentList;
    }

    public Student getStudentById(int id)
    {
        for(Student student:studentList)
        {
            if(student.getId()==id)
            {
                return  student;
            }
        }
        return null;
    }
}
