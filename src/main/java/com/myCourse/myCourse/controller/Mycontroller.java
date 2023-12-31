package com.myCourse.myCourse.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myCourse.myCourse.entities.Course;
import com.myCourse.myCourse.services.CourseServices;


@RestController	
public class Mycontroller {
	
	
	@Autowired
	private CourseServices courseService;
	
	
	
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String Home() {
		return "Welcome to My Course Application."; 
	}
	
	
	
	
	// Get the Courses List
	@GetMapping("/courses")
	public List<Course> getCourses(){	
		return this.courseService.getCourses();
	}
	
	
	// Get the Single Course List
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {	
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	
	// Add the course to the List
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	
	// Update the course to the List
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {	
		return this.courseService.updateCourse(course);
	}
	
	
	// Delete the Course from List
//	@DeleteMapping("/courses/{courseId}")
//	public Course deleteCourse(@PathVariable String courseId) {	
//		return this.courseService.deleteCourse(Integer.parseInt(courseId));
//	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {	
		
		try {
			
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
