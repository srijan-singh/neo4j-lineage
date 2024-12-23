package com.java.neo4j.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.neo4j.crud.entity.Course;
import com.java.neo4j.crud.service.CourseService;
import com.java.neo4j.crud.templates.CourseTemplate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// CRUD
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create
    @PostMapping("/course/add")
    public ResponseEntity<Course> postMethodName(@RequestBody CourseTemplate courseTemplate) {
        Course course = courseService.addCourse(courseTemplate);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/courses/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    // Update
    @PutMapping("/course/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseTemplate courseTemplate) {
        Course course = courseService.updateCourse(courseTemplate, id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/course/delete/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id) {
        courseService.removeCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
