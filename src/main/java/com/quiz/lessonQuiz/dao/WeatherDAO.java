package com.quiz.lessonQuiz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lessonQuiz.model.Weather;

@Repository
public interface WeatherDAO {

	public List<Weather> selectWeather(); //쿼리문의 result타입이 model주소인 이유: DAO에서 받는 데이터가 LIST이기 때문이다.
	
}
