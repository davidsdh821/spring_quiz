package com.quiz.lessonQuiz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lessonQuiz.bo.WeatherBO;
import com.quiz.lessonQuiz.model.Weather;

@RequestMapping("/lessonquiz")
@Controller
public class LessonQuiz01 {
	@Autowired
	private WeatherBO weatherBO;
	
	
	//http://localhost/lessonquiz/LessonQuiz01
	@GetMapping("/LessonQuiz01")
	public String quiz01(Model model) {
		
		List<Weather> date = weatherBO.getWeather();//이 방식이 보기가 편하다
		
		model.addAttribute("weather", date);

		return "lesson04/quiz01";
	}
	
	@PostMapping("/add_weather") 
	public String addWeather(@RequestParam("date") String date){
		
		//insert팁: date타입 같은 경우도 string으로 집어넣어도 mysql에서 알아서 변환해준다
		//만약 찝찝한 경우  reqparm- @datetimeformat("yyyy-mm-dd") Date date으로 써주면 자바에서 변환해준다
		//ModelAttribute를 사용하려면 model.weather의 date 부분에 @datetimeformat("yyyy-mm-dd")를 넣어주면 된다
		
		
		//리다이렉트, 문법 그자체이다.
		//이곳에서 리다이렉트를 하면 값이 보내진 후 null이 됨으로 다시 처음의 상태로 돌아간다.
		return "redirect:/lessonquiz/LessonQuiz01";
	}
	
	
	
}
