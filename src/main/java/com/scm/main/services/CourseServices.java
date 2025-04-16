package com.scm.main.services;

import java.util.List;
import java.util.Optional;

import com.scm.main.entities.Course;

public interface CourseServices {

	public Course insertCourse(Course course);
	public List<Course> getCourses();
	public Optional<Course> findById(long id);
	public Course updateCourse(Course course);
	public void deleteCourse(long id);
}
