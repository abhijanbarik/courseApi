package com.myCourse.myCourse.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myCourse.myCourse.dao.CourseDao;
import com.myCourse.myCourse.entities.Course;


@Service
public class CourseServicesImpl implements CourseServices {
	
	@Autowired
	private CourseDao courseDao;
	
	
//	List<Course> list;
	
	
	// Service Layer
	public CourseServicesImpl() {
		
//		list = new ArrayList<>();
//		
//		list.add(new Course(101, "Core Java", "This course will teach you everything about Java."));
//		list.add(new Course(102, "DSA", "This course will teach you everything about DSA."));
//		list.add(new Course(103, "Backend Development", "This course will teach you everything about Backend Web Development."));
//		list.add(new Course(104, "Python", "This course will teach you everything about basic of Python."));
	}
	

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}


	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(int courseId) {
		
//		Course c = null;
//		
//		for(int i = 0; i < list.size(); i++) {
//			
//			c = list.get(i);
//			
//			if(c.getId() == courseId) { 
//				
//				c = list.get(i); 
//				
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		
//		Course t = null;
//		
//		for(int i = 0; i < list.size(); i++) {
//			
//			t = list.get(i);
//			
//			if(t.getId() == courseId) {
//				
//				list.set(i, course);
//			}
//		}
		
		courseDao.save(course);
		
		return course;
	}


	@Override
	public Course deleteCourse(int courseId) {
		
//		Course c = null;
//		
//		for(int i = 0; i < list.size(); i++) {
//			
//			c = list.get(i);
//			
//			if(c.getId() == courseId) list.remove(i);
//		}
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		return entity;
	}


	

}
