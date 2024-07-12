package com.codingdojo.javaproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javaproj.models.Contact;
import com.codingdojo.javaproj.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}
}
