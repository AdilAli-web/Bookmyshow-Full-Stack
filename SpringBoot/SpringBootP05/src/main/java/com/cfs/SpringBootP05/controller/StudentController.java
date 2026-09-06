package com.cfs.SpringBootP05.controller;

import com.cfs.SpringBootP05.entity.Student;
import com.cfs.SpringBootP05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudent()
    {
        return service.getAllStudentData();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student)
    {
        return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id)
    {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id)
    {
        service.deleteStudent(id);
        return "Student deleted";
    }

}
