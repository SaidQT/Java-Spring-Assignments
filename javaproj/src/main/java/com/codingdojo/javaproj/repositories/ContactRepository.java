package com.codingdojo.javaproj.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javaproj.models.Contact;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

	
}
