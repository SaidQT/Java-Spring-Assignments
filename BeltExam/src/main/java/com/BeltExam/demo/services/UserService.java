package com.BeltExam.demo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.BeltExam.demo.models.LoginUser;
import com.BeltExam.demo.models.User;
import com.BeltExam.demo.repositories.UserRepository;

@Service
public class UserService {
	
		
	@Autowired
	private UserRepository userRepo;
	
	 public User register(User newUser, BindingResult result) {
		 Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		 if(optionalUser.isPresent()) {
			 result.rejectValue("email","Found","The email you entered is already used");
			 return null;
		 }
		 if(!newUser.getConfirm().equals(newUser.getPassword())) {
			 result.rejectValue("password", "Matches", "The passwords you entered do not match");
			 return null;
		 }
		 
		 String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		 newUser.setPassword(hashed);
		 userRepo.save(newUser);
		 return newUser;
		 


	 }
	 
	 public User login(LoginUser login,  BindingResult result ) {
		 Optional<User> optionalUser = userRepo.findByEmail(login.getEmail());
		 if(!optionalUser.isPresent()) {
			 result.rejectValue("email","notFound","The email you entered does not exist");
			 return null;
		 }
		 
		 if(!BCrypt.checkpw(login.getPassword(), optionalUser.get().getPassword())) {
			    result.rejectValue("password", "Matches", "Invalid Password!");
			    return null;
			    
			}
		 return optionalUser.get();
			 	 
	 }
	 
}



