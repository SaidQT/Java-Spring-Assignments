package com.codingdojo.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	 public List<Dojo> allDojos() {
	        return dojoRepository.findAll();
	    }
	    public Dojo createDojo(Dojo b) {
	        return dojoRepository.save(b);
	    }

	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
}
