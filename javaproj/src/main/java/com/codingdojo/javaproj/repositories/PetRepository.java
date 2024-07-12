package com.codingdojo.javaproj.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javaproj.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
	List<Pet> findAll();
	
}
