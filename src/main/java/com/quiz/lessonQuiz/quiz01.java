package com.quiz.lessonQuiz;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lessonquiz")
@RestController
public class quiz01 {
	
	//http://localhost/lessonquiz/quiz01
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		
		
		
		return "quiz/quiz01";
	}
	
	
	
}
