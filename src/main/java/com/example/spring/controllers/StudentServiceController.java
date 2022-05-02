package com.example.spring.controllers;

import com.example.spring.models.Student;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@RestController
public class StudentServiceController {

    private static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student("Sam", 3.75),
            new Student("Lisa", 4.0),
            new Student("Ming", 1.5),
            new Student("Lynda", 2.85)
    ));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentList;
    }

    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public Student getStudentByIndex(@PathVariable String name) {
        List<Student> students = new ArrayList<>();
        for(Student student : studentList){
            if(student.getName().equals(name)){
                students.add(student);
                return students.get(0);
            }
        }
        return null;
    }
}