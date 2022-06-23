package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.Quiz01DAO;
import com.quiz.lesson02.model.Store;

@Service
public class Quiz01BO {

	
	@Autowired //2 
	private Quiz01DAO quiz01DAO;
	// 데이터가 없기 때문에 dao의 리스트를 가져옴
	public List<Store> getStoreList() {
		
		return quiz01DAO.selectStoreList(); //dao의 것을 가져옴
	}
	
}

