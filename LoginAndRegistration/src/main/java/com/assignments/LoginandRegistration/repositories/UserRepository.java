package com.assignments.LoginandRegistration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.LoginandRegistration.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Override
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
}

