package com.scm.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.scm.main.entities.Course;
import com.scm.main.services.CourseServices;
import org.springframework.web.bind.annotation.PutMapping;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

	@Autowired
	CourseServices cs;
	
	@GetMapping("/home")
	public String home() {
		
		return "u are in home page";
	}
	
	// insert the courses
	@PostMapping("/course")
	public Course insertcourse(@RequestBody Course course) {
		return cs.insertCourse(course);
	}
	
	
	// get all courses
		
		@GetMapping("/course")
		public List<Course> getAllCourses(){
			return cs.getCourses();
			
		}
	
		// get course by id
		@GetMapping("/course/{id}")
		public ResponseEntity<Course> getCourseById(@PathVariable long id){
			Course course = cs.findById(id).orElse(null);
			if(course!=null) {
				return ResponseEntity.ok().body(course);
			}else {
				return ResponseEntity.notFound().build();
			}	
		}
		
		// delete course by id
		@DeleteMapping("course/{id}")
		public ResponseEntity<String> deleteCourse(@PathVariable long id) {
				cs.deleteCourse(id);
				return ResponseEntity.ok("User deleted successfully");
				
			}
		
		// update Course
		@PutMapping("/course")
		public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
			Course c = cs.updateCourse(course);
			if(c!=null) {
				return ResponseEntity.ok().body(c);
			}else {
				return ResponseEntity.notFound().build();
	    }		
		}
		
	
	
}
