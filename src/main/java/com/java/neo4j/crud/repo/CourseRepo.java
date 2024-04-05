package com.java.neo4j.crud.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.java.neo4j.crud.entity.Course;

public interface CourseRepo extends Neo4jRepository<Course, Long> {

}
