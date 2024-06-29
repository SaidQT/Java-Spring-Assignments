package com.codingdojo.ninjagold;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
	public static HashMap<String, String> randomMap = new HashMap<String, String>();

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			
		}
		session.setAttribute("log", " ");
		return "index.jsp";
	}

	@PostMapping("/play")
	public String play(@RequestParam(name = "game") String game, HttpSession session, Random randNumber) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy hh:mm");
		String formattedDate = dateFormat.format(new java.util.Date());

		int countGold = (int) session.getAttribute("count");

		if (game.equals("farm")) {
			session.setAttribute("coloring", "green");
			int rand = randNumber.nextInt(10, 21);
			countGold += rand;
			String gaming = String.format("%d %s", rand, game);
			if (!randomMap.containsKey(gaming)) {

				randomMap.put(gaming, "You entered a farm and won " + rand + ". " + formattedDate);
			}
			String playing = randomMap.get(gaming);
//          session.setAttribute("activity", playing);
			String login = (String) session.getAttribute("log");
			Set<String> keys = randomMap.keySet();
	        for(String key : keys) {
	            System.out.println(key);
	            System.out.println(randomMap.get(key));
	        }
			System.out.println(login);
			login += playing + "/n";
			session.setAttribute("log", login);
		}

		if (game.equals("cave")) {
			session.setAttribute("coloring", "green");

			int rand = randNumber.nextInt(5, 11);
			countGold += rand;
			String gaming = String.format("%d %s", rand, game);
			if (!randomMap.containsKey(gaming)) {

				randomMap.put(gaming, "You entered a cave and won " + rand + ". " + formattedDate);
			}
			String playing = randomMap.get(gaming);
//          session.setAttribute("activity", playing);
			StringBuilder login = (StringBuilder) session.getAttribute("log");
			login.append(playing);
			session.setAttribute("log", login);
		}

		if (game.equals("house")) {
			session.setAttribute("coloring", "green");

			int rand = randNumber.nextInt(2, 6);

			countGold += rand;
			String gaming = String.format("%d %s", rand, game);
			if (!randomMap.containsKey(gaming)) {
				randomMap.put(gaming, "You entered a house and won " + rand + ". " + formattedDate);
			}
			String playing = randomMap.get(gaming);
//          session.setAttribute("activity", playing);
			StringBuilder login = (StringBuilder) session.getAttribute("log");
			login.append(playing);
			session.setAttribute("log", login);
		}

		if (game.equals("quest")) {
			int rand = randNumber.nextInt(-50, 51);

			countGold += rand;
			if (rand < 0) {
				session.setAttribute("coloring", "red");

				String gaming = String.format("%d %s", rand, game);
				if (!randomMap.containsKey(gaming)) {
					randomMap.put(gaming, "You failed a quest and lost " + rand + ". " + formattedDate);
				}
				String playing = randomMap.get(gaming);
//	          session.setAttribute("activity", playing);
				StringBuilder login = (StringBuilder) session.getAttribute("log");
				login.append(playing);
				session.setAttribute("log", login);
			} else {
				session.setAttribute("coloring", "green");

				String gaming = String.format("%d %s", rand, game);
				if (!randomMap.containsKey(gaming)) {
					randomMap.put(gaming, "You succeeded in a quest and gained " + rand + ". " + formattedDate);
				}
				String playing = randomMap.get(gaming);
//	          session.setAttribute("activity", playing);
				StringBuilder login = (StringBuilder) session.getAttribute("log");
				login.append(playing);
				session.setAttribute("log", login);
			}
		}

		if (game.equals("spa")) {
			session.setAttribute("coloring", "red");

			int rand = randNumber.nextInt(5, 21);
			String gaming = String.format("%d  %s", rand, game);
			countGold -= rand;
			if (!randomMap.containsKey(gaming)) {
				randomMap.put(gaming, "You visited a Spa and lost  " + rand + ". " + formattedDate);
			}
			String playing = randomMap.get(gaming);
//          session.setAttribute("activity", playing);
			StringBuilder login = (StringBuilder) session.getAttribute("log");
			login.append(playing);
			session.setAttribute("log", login);
		}

		session.setAttribute("count", countGold);
		return "redirect:/";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}

}
