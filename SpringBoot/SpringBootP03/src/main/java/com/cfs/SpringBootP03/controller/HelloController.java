package com.cfs.SpringBootP03.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello Spring boot";
    }

   /* @GetMapping("/students")
    public List<String> getStudents()
    {
        return List.of("Rahul","Priya","Shreya");
    }*/

}
