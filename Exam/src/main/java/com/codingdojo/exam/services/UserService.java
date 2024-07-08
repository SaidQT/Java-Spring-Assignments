package com.codingdojo.exam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User register(User newUser, BindingResult result) {
		String email = newUser.getEmail();
		Optional<User> optionalUser= userRepo.findByEmail(email);
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "exists", "Email already exists!");
			return null;
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLogin, BindingResult result) {
	    Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	    
	    if (!potentialUser.isPresent()) {
	        result.rejectValue("email", "NotFound", "User not found for this email address");
	        return null;
	    }
	    
	    User user = potentialUser.get();
	    
	    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	        result.rejectValue("password", "Matches", "Invalid Password or Email Address!");
	    }
	    
	    return user;
	}
}