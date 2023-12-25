package com.myCourse.myCourse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myCourse.myCourse.entities.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
	
	
}
