package com.cfs.StudentAPI.controller;

import com.cfs.StudentAPI.model.Student;
import com.cfs.StudentAPI.service.CourseService;
import com.cfs.StudentAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //field DI
   // @Autowired
    private StudentService studentService;

    public CourseService getCourseService() {
        return courseService;
    }


    //optional Dependency
    @Autowired(required = false)
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    private CourseService courseService;

   @Autowired
    public void setService(StudentService studentService) {
        this.studentService = studentService;
    }

    //Mandatory
        @Autowired
          public StudentController(StudentService studentService) {
                this.studentService = studentService;
            }


    //student
    @GetMapping
    public List<Student> getAllStudents()
    {
       return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id)
    {
        Student student= studentService.getStudentById(id);
        if(student==null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }
}
