package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.Quiz01BO;
import com.quiz.lesson02.model.Store;

@RestController 
public class Lesson02Quiz01 {
	
	
	@Autowired //1
	private Quiz01BO quiz01bo;
	//bo한테 데이터를 요청, 가져올 준비
	
	@RequestMapping("/lesson02/quiz02")
	public List<Store> quiz01() {
	
		return quiz01bo.getStoreList(); //bo의 것을 가져옴
	}

}
