package com.java.neo4j.crud.service;

import com.java.neo4j.crud.entity.Course;
import com.java.neo4j.crud.templates.CourseTemplate;

import java.util.List;

// CRUD
public interface CourseService {

    // Create
    public Course addCourse(CourseTemplate course);

    // Read
    public Course getCourseById(Long id);

    public List<Course> getAllCourses();

    // Update
    public Course updateCourse(CourseTemplate courseTemplate, Long id);

    // Delete
    public void removeCourse(Long id);

}
