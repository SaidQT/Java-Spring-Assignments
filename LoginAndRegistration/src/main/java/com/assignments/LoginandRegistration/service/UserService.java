package com.assignments.LoginandRegistration.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignments.LoginandRegistration.Models.Course;
import com.assignments.LoginandRegistration.Models.LogIn;
import com.assignments.LoginandRegistration.Models.User;
import com.assignments.LoginandRegistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;

	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userrepo.findByEmail(newUser.getEmail());

		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "the Confirm password must match Password ");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userrepo.save(newUser);

	}

	public User login(LogIn newLogin, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userrepo.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found");
			return null;
		}
		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}

	public User findUser(Long id) {
		Optional<User> optionalUser = userrepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}

	}

}
