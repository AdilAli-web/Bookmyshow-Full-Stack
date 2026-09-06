package com.cfs.SpringBootP03.controller;

import com.cfs.SpringBootP03.dto.StudentRequest;
import com.cfs.SpringBootP03.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentPost {

    @PostMapping("/create")
    public String createStudent(@RequestBody StudentRequest request)
    {
        return "Student created :"+request.getName();
    }


}
