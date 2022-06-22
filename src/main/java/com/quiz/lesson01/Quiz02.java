package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
//RestController + responsebody
@RestController 
public class Quiz02 {
	
	//Controller + responsebody => massageConverter 클래스 참조
	//MassageConverter: jackson 라이브러리를 찾아서 변환시켜줌
	//http://localhost:8080/lesson01/quiz02/1
	
	@RequestMapping("/1")
	public List<Map<String, String>> quiz02_1() {
		ArrayList<Map<String, String>> movies = new ArrayList<>();
		Map<String, String> movie_info1 = new HashMap<>();
		// movie_info1 = new HashMap<>(); 이런 식으로 이름은 같지만 새로운 map을 만들어 사용해도 된다.
		 
		movie_info1.put("rate", "15");
		movie_info1.put("director", "봉준호");
		movie_info1.put("time", "131");
		movie_info1.put("title", "기생충");
		movies.add(movie_info1);
		
		Map<String, String> movie_info2 = new HashMap<>();
		movie_info2.put("rate", "0");
		movie_info2.put("director", "로베르트 베니니");
		movie_info2.put("time", "116");
		movie_info2.put("title", "인생은 아름다워");
		movies.add(movie_info2);
		
		Map<String, String> movie_info3 = new HashMap<>();
		movie_info3.put("rate", "12");
		movie_info3.put("director", "크리스토퍼 놀란");
		movie_info3.put("time", "147");
		movie_info3.put("title", "인셉션");
		movies.add(movie_info3);
		
		Map<String, String> movie_info4 = new HashMap<>();
		movie_info4.put("rate", "19");
		movie_info4.put("director", "윤종빈");
		movie_info4.put("time", "133");
		movie_info4.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");
		movies.add(movie_info4);
		
		Map<String, String> movie_info5 = new HashMap<>();
		movie_info5.put("rate", "15");
		movie_info5.put("director", "프란시스 로렌스");
		movie_info5.put("time", "137");
		movie_info5.put("title", "헝거게임");
		movies.add(movie_info5);
		
		return movies;
	}
	
	//http://localhost:8080/lesson01/quiz02/2
	
	@RequestMapping("/2")
	public List<Data> quiz02_2() {
		List<Data> list = new ArrayList<>();
		Data data = new Data();
		data.setTitle("안녕하세요 가입인사드립니다.");
		data.setUser("hanglu");
		data.setContent("가입했다. 이 몸 등장");
		list.add(data);
		
		data = new Data();
		data.setTitle("안녕하세요 가입인사합니다");
		data.setUser("avad");
		data.setContent("나다");
		list.add(data);
		
		return list;
	}
	
	//http://localhost:8080/lesson01/quiz02/3
	
	@RequestMapping("/3")
	public ResponseEntity<Data> quiz02_3() {
		List<Data> list = new ArrayList<>();
		Data data = new Data();
		data.setTitle("안녕하세요 가입인사드립니다.");
		data.setUser("hanglu");
		data.setContent("가입했다. 이 몸 등장");
		list.add(data);
		
		
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 

}
