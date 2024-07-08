package com.assignments.LoginandRegistration.repositories;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.LoginandRegistration.Models.Course;
import com.assignments.LoginandRegistration.Models.User;

@Repository

public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();

	List<Course> findByDescriptionContaining(String search);


}
