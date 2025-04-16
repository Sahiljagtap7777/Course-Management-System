package com.scm.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.main.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	   
}
