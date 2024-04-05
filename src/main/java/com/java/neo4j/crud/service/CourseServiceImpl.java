package com.java.neo4j.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.neo4j.crud.entity.Course;
import com.java.neo4j.crud.repo.CourseRepo;
import com.java.neo4j.crud.templates.CourseTemplate;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepository;

    @Override
    public Course addCourse(CourseTemplate courseTemplate) {
        Course course = new Course();
        course.setIdentifier(courseTemplate.getIdentifier());
        course.setTitle(courseTemplate.getTitle());
        course.setTeacher(courseTemplate.getTeacher());
        
        courseRepository.save(course);
        
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(CourseTemplate courseTemplate, Long id) {
        Course course = getCourseById(id);

        course.setIdentifier(courseTemplate.getIdentifier());
        course.setTitle(courseTemplate.getTitle());
        course.setTeacher(courseTemplate.getTeacher());
        
        courseRepository.save(course);
        
        return course;
    }

    @Override
    public void removeCourse(Long id) {
        courseRepository.deleteById(id);
    }

}
