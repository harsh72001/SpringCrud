package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.pratice.spring.entities.Cource;

@Service
public class CourseServiceImpl implements CourseService {

	
	
	 List<Cource> list ;
	 
	 public CourseServiceImpl() {
		 list = new ArrayList<>();
		 list.add(new Cource(145 , "Java Core Course" ,"this cource contain basic of java"));
		 list.add(new Cource(434 , "Spring boot course" , "createing rest api using spring boot"));
	 }
	 
	@Override
	public List<Cource> getCourses() {
		
		return list;
	}

	@Override
	public Cource getCourse(long courseId) {
      
		Cource c = null;
		for(Cource course:list)
		{
			if(course.getId()== courseId ) {
				c=course;
				break;
				
			}
		}
		return c;
	}

	@Override
	public Cource addCource(Cource course) {
     list.add(course);
     return course;
     
	}

	@Override
	public Cource updateCourse(Long courseId, Cource course) {
		for (Cource course1 : list) {
            if (course1.getId() == courseId) {
                // Update the course with the provided details
                course1.setTitle(course.getTitle());
                course1.setDescription(course.getDescription());
                return course1; // Return the updated course
            }
        }
        return null;}

	@Override
	public void deleteCourse(Long courseId) {
		 Iterator<Cource> iterator = list.iterator();
	        while (iterator.hasNext()) {
	            Cource course = iterator.next();
	            if (course.getId() == courseId) {
	                iterator.remove(); // Remove the course with the given ID
	            }
	        }
	    }
	}