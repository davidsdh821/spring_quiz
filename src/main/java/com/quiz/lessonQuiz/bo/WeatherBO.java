package com.quiz.lessonQuiz.bo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lessonQuiz.dao.WeatherDAO;
import com.quiz.lessonQuiz.model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;
	

	public List<Weather> getWeather() { //여러개의 데이터를 가져올것이기 때문에 List로 한다
		
		return weatherDAO.selectWeather();
	}
	
}
