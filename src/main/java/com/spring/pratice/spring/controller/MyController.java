package com.spring.pratice.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.pratice.spring.entities.Cource; // Changed to Cource
import com.springrest.springrest.services.CourseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Welcome to the application";
    }

    @GetMapping("/courses")
    @Operation(summary="Show All the cources")
    public ResponseEntity<List<Cource>> getCources() { // Changed to getCources
        List<Cource> cources = courseService.getCourses(); // Changed to cources
        return ResponseEntity.ok(cources);
    }

    @GetMapping("/courses/{courseId}")
    @Operation(summary="Show courses by id")
    public ResponseEntity<Cource> getCourse(@PathVariable Long courseId) {
        Cource cource = courseService.getCourse(courseId); // Changed to cource
         
        if (cource != null) {
            return ResponseEntity.ok(cource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    

    @PostMapping("/courses")
    @Operation(summary="Add new course")
    public ResponseEntity<Cource> addCourse(@RequestBody Cource cource) { // Changed to cource
        if (cource != null) {
            Cource addedCource = courseService.addCource(cource); // Changed to addedCource and addCource
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCource);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/courses/{courseId}")
    @Operation(summary="Update the couerse")
    public ResponseEntity<Cource> updateCourse(@PathVariable Long courseId, @RequestBody Cource cource) { // Changed to cource
        Cource updatedCource = courseService.updateCourse(courseId, cource); // Changed to updatedCource and updateCourse
        if (updatedCource != null) {
            return ResponseEntity.ok(updatedCource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/courses/{courseId}")
    @Operation(summary="Delete the courses")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
