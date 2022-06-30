package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.RealtorDAO;
import com.quiz.lesson04.model.Realtor;

@Service
public class RealtorBO {
	@Autowired
	RealtorDAO realtorDAO;
	
	public void addRealtor(Realtor realtor) { //객체를 통으로 가져옴
		
		realtorDAO.inesrtRealtorById(realtor);
	}
	public Realtor getLastRealtor(int id) {
		
		return realtorDAO.selectLastRealtor(id);
	}

}
