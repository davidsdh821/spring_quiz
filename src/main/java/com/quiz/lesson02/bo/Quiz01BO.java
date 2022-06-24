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
	// dao의 데이터를 가져옴
	public List<Store> getStoreList() {
		
		return quiz01DAO.selectStoreList(); //dao에게 받아온 데이터를 리턴
	}
	
}

