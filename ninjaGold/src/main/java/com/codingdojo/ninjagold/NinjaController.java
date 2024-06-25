package com.codingdojo.ninjagold;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
@RequestMapping("/")
public String index (HttpSession session) {
	if (session.getAttribute("count") == null){
		session.setAttribute("count", 0);
		session.setAttribute("activity", new ArrayList<String>());

	}

	return "index.jsp";
}
@PostMapping("/play")
public String play(@RequestParam(name= "game") String game, HttpSession session, Random randNumber){
	// Random randNumber= new Random();
	SimpleDateFormat dateFormat = new SimpleDateFormat("E.dd.MM.yyyy hh:mm");
          String formattedDate = dateFormat.format(new java.util.Date());
	ArrayList<String> activities=(ArrayList<String>) session.getAttribute("activity");
	int countGold= (int) session.getAttribute("count");
	if (game.equals("farm") ){
		int rand = randNumber.nextInt(10,21);
		countGold += rand;
		activities.add("You entered a farm and won" + " " + rand+"."+" "+ formattedDate);
	}
	if (game.equals("cave")){
		int rand = randNumber.nextInt(5,11);
		countGold += rand;
		activities.add("You entered a cave and won" + " " + rand+"."+" "+ formattedDate);
	}
	if (game.equals("house")){
		int rand = randNumber.nextInt(2,6);
		countGold += rand;
		activities.add("You entered a house and won" + " " + rand+"."+" "+ formattedDate);
	}
	if ( game.equals("quest")){
		int rand = randNumber.nextInt(-50,51);
		countGold += rand;
		if (rand < 0 ){
			activities.add("You failed a quest and lost" + " "+ rand+"."+" "+ formattedDate);
		}
		else{
			activities.add("You completed a quest and won" + " "+ rand+"."+" "+ formattedDate);
		}
	}
	if(game.equals("spa")){
		int rand= randNumber.nextInt(-20,-4);
		activities.add("You entered spa and lost"+ " "+ rand+"."+" "+formattedDate);
		countGold+=rand;
	}
	session.setAttribute("count", countGold);
	   
	return "redirect:/";
}
@RequestMapping("/reset")
public String reset(HttpSession session){
	session.setAttribute("count", 0);
	session.setAttribute("activity", new ArrayList<String>());
	return "redirect:/";
}
}
