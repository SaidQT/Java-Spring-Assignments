package com.assignments.LoginandRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.LoginandRegistration.Models.Course;

@Repository

public interface CourseRepository extends CrudRepository<Course,Long>{
	List<Course> findAll();
    List<Course> findByDescriptionContaining(String search);
   
}
