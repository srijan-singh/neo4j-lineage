package com.java.neo4j.crud.service;

import com.java.neo4j.crud.entity.Course;
import com.java.neo4j.crud.templates.CourseTemplate;

import java.util.List;

public interface CourseService {

    public Course addCourse(CourseTemplate course);
    public List<Course> getAllCourses();

}
