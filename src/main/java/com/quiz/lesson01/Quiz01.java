package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Quiz01 {
	@RequestMapping("/lesson01/quiz01/1")
	@ResponseBody
	public String ex01_1() {
		String text = "<h1>�׽�Ʈ ������Ʈ �ϼ�</h1> �ش� ������Ʈ�� ���ؼ� ���� Ǯ�̸� ���� �մϴ�.";
		 
		return text;
	}
	
	
	//http://localhost:8080/lesson01/quiz01/2
	//������Ʈ ���� ���� �ٲ��� ����
	
	@RequestMapping("/lesson01/quiz01/2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		   
		
		map.put("����", 80);
		map.put("����", 90);
		map.put("����", 85);
		
		return map;
	}
	
	//���������� �̷������� ������.
}
