package com.springrest.springrest.services;

import java.util.List;

import com.spring.pratice.spring.entities.Cource;

public interface CourseService {
	
 public List<Cource> getCourses();
 
 public Cource getCourse(long courseId);
 
 public Cource addCource(Cource course);
 
 public Cource updateCourse(Long courseId, Cource course);

public void deleteCourse(Long courseId);
}
