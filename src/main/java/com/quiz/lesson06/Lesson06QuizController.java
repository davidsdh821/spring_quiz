package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06")
@Controller
public class Lesson06QuizController {

	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "";
	}
	
	
}
