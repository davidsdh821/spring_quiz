package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.favorite;

@RequestMapping("/lesson06")
@Controller
public class Lesson06QuizController {

	@Autowired
	FavoriteBO favoriteBO;
	
	
	//http://localhost/lesson06/quiz01
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "lesson06/addFavorite";
	}
	
	@PostMapping("/quiz01_2")
	public String quiz01_2(@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		favoriteBO.addFavoriteAsField(name, url);
		
		
		return "입력성공";
	}
	//http://localhost/lesson06/quiz01_3
	@GetMapping("/quiz01_3") 
	public String quiz01_3(Model model) {
		List<favorite> result = favoriteBO.getFavorite();
		
		model.addAttribute("result", result);
		
		
		return "lesson06/viewFavorite";
	}
	
	
}
