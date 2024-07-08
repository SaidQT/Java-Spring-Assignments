package com.assignments.LoginandRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignments.LoginandRegistration.Models.Course;
import com.assignments.LoginandRegistration.Models.User;
import com.assignments.LoginandRegistration.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepo;

	public List<Course> allCourses() {
		return courseRepo.findAll();
	}

	public Course createCourse(Course b, User user) {
		b.setUser(user);
		return courseRepo.save(b);
	}

	public Course updateCourse(Course b, User user) {
		b.setUser(user);
		return courseRepo.save(b);
	}
	public Course update(Course b) {
		
		return courseRepo.save(b);
	}

	public void deleteById(Long id) {
		courseRepo.deleteById(id);
	}

	public Course findCourse(Long id) {
		Optional<Course> optionalCourse = courseRepo.findById(id);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}
	
}
