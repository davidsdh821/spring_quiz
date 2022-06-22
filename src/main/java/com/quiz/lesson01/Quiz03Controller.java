package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost8080/lesson01/quiz03/1
@RequestMapping("/lesson01/quiz03")
@Controller //restcontrol은 안된다.
public class Quiz03Controller {
	//http://localhost8080/lesson01/quiz03/1
	@RequestMapping("/1")
	public String quiz03_1() {
		//	/WEB-INF/jsp/(prefix)  lesson01/quiz03	 .jsp(suffix)
		return "lesson01/quiz03"; 
	}
	 
	
}
