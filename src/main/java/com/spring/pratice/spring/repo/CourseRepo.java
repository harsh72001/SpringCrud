package com.spring.pratice.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pratice.spring.entities.Cource;

@Repository
public interface CourseRepo extends JpaRepository<Cource, Long> {

}
