package com.codingdojo.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

@RequestMapping("/")
public String index(@RequestParam(value="name", required=false) String firstName, @RequestParam(value="lastname", required= false) String lastName) {
	if (!(firstName == null) && !firstName.isEmpty() && (lastName == null)) {
    return "Hello " + firstName;
	}
	else if (!(firstName == null) && !firstName.isEmpty() && !(lastName == null) && (!lastName.isEmpty())) {
		return "Hello " + firstName+ " "+lastName;
	}
	else {
		return "Hello Human";
	}
}

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

}
