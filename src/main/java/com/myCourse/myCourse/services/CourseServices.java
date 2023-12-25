package com.myCourse.myCourse.services;

import java.util.*;
import com.myCourse.myCourse.entities.Course;

public interface CourseServices {
	
	public List<Course> getCourses();
	
	public Course getCourse(int courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public Course deleteCourse(int courseId);

}
