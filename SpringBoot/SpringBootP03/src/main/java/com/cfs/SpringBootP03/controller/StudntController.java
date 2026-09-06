package com.cfs.SpringBootP03.controller;


import com.cfs.SpringBootP03.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudntController {

    @GetMapping("/student")
    public Student getStudent()
    {
        return new Student(101,"Priya",10);
    }

   /* @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable int id)
    {
        return "Student id is "+id;
    }
*/
    @GetMapping("/student/search")
    public String searchStudent(@RequestParam String course)
    {
        return "Search students for course: "+course;
    }

    @GetMapping("/product/search")
    public String searchProduct(@RequestParam(required = true) String cat,@RequestParam(defaultValue = "101") double minPrice)
    {
        return "product:"+cat+" "+minPrice;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<String> getStudent(@PathVariable int id)
    {
        if(id<=0)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid student id");
        }

        return ResponseEntity.ok("Student found");
    }


}
