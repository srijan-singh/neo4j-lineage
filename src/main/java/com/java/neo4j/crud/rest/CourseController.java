package com.java.neo4j.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.neo4j.crud.entity.Course;
import com.java.neo4j.crud.service.CourseService;
import com.java.neo4j.crud.templates.CourseTemplate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/add")
    public ResponseEntity<Course> postMethodName(@RequestBody CourseTemplate courseTemplate) {
        Course course = courseService.addCourse(courseTemplate);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    

    @GetMapping("/courses/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }


}
