package com.cfs.SpringBootP05.service;

import com.cfs.SpringBootP05.entity.Student;
import com.cfs.SpringBootP05.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRespository respository;

    public List<Student> getAllStudentData()
    {
        List<Student> all = respository.findAll();
        return all;
    }

    public Student saveStudent(Student student)
    {
        return respository.save(student);
    }

    public Student getStudentById(Long id)
    {
        return respository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id)
    {
        respository.deleteById(id);
    }



}
