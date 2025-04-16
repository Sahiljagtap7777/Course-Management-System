package com.scm.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.main.entities.Course;
import com.scm.main.repositories.CourseRepository;

@Service
public class CourseServicesImpl implements CourseServices {

	@Autowired
	CourseRepository cr;
	
	

	@Override
	public Course insertCourse(Course course) {
		if (course.getId() != null) {
	        // Check if it already exists — update or throw conflict
	        Optional<Course> existing = cr.findById(course.getId());
	        if (existing.isPresent()) {
	            throw new RuntimeException("Course with this ID already exists!");
	        }
	    }
	    return cr.save(course);
	}



	@Override
	public List<Course> getCourses() {
		
		return cr.findAll();
	}



	@Override
	public Optional<Course> findById(long id) {
		
		return cr.findById(id);
	}



	@Override
	public void deleteCourse(long id) {
		cr.deleteById(id);
		
	}



	@Override
	public Course updateCourse(Course course) {
		Course c = cr.findById(course.getId()).orElse(null);
		
		if(c!=null) {
			c.setTitle(course.getTitle());
			c.setDescription(course.getDescription());
			return cr.save(c);
		}else {
			throw new RuntimeException("course not found") ;
		}
	}

}
