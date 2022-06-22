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
	
	//Controller + responsebody => massageConverter Ŭ���� ����
	//MassageConverter: jackson ���̺귯���� ã�Ƽ� ��ȯ������
	//http://localhost:8080/lesson01/quiz02/1
	
	@RequestMapping("/1")
	public List<Map<String, String>> quiz02_1() {
		ArrayList<Map<String, String>> movies = new ArrayList<>();
		Map<String, String> movie_info1 = new HashMap<>();
		// movie_info1 = new HashMap<>(); �̷� ������ �̸��� ������ ���ο� map�� ����� ����ص� �ȴ�.
		 
		movie_info1.put("rate", "15");
		movie_info1.put("director", "����ȣ");
		movie_info1.put("time", "131");
		movie_info1.put("title", "�����");
		movies.add(movie_info1);
		
		Map<String, String> movie_info2 = new HashMap<>();
		movie_info2.put("rate", "0");
		movie_info2.put("director", "�κ���Ʈ ���ϴ�");
		movie_info2.put("time", "116");
		movie_info2.put("title", "�λ��� �Ƹ��ٿ�");
		movies.add(movie_info2);
		
		Map<String, String> movie_info3 = new HashMap<>();
		movie_info3.put("rate", "12");
		movie_info3.put("director", "ũ�������� ���");
		movie_info3.put("time", "147");
		movie_info3.put("title", "�μ���");
		movies.add(movie_info3);
		
		Map<String, String> movie_info4 = new HashMap<>();
		movie_info4.put("rate", "19");
		movie_info4.put("director", "������");
		movie_info4.put("time", "133");
		movie_info4.put("title", "���˿��� ����: ���۳�� �����ô�");
		movies.add(movie_info4);
		
		Map<String, String> movie_info5 = new HashMap<>();
		movie_info5.put("rate", "15");
		movie_info5.put("director", "�����ý� �η���");
		movie_info5.put("time", "137");
		movie_info5.put("title", "��Ű���");
		movies.add(movie_info5);
		
		return movies;
	}
	
	//http://localhost:8080/lesson01/quiz02/2
	
	@RequestMapping("/2")
	public List<Data> quiz02_2() {
		List<Data> list = new ArrayList<>();
		Data data = new Data();
		data.setTitle("�ȳ��ϼ��� �����λ�帳�ϴ�.");
		data.setUser("hanglu");
		data.setContent("�����ߴ�. �� �� ����");
		list.add(data);
		
		data = new Data();
		data.setTitle("�ȳ��ϼ��� �����λ��մϴ�");
		data.setUser("avad");
		data.setContent("����");
		list.add(data);
		
		return list;
	}
	
	//http://localhost:8080/lesson01/quiz02/3
	
	@RequestMapping("/3")
	public ResponseEntity<Data> quiz02_3() {
		List<Data> list = new ArrayList<>();
		Data data = new Data();
		data.setTitle("�ȳ��ϼ��� �����λ�帳�ϴ�.");
		data.setUser("hanglu");
		data.setContent("�����ߴ�. �� �� ����");
		list.add(data);
		
		
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 

}
