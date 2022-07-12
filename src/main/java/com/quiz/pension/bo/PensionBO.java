package com.quiz.pension.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.pension.dao.PensionDAO;
import com.quiz.pension.model.Pension;

@Service
public class PensionBO {
	@Autowired
	PensionDAO pensionDAO;
	
	
	
	//get
	public List<Pension> getPension() {
		
		
		return pensionDAO.selectPension();
	}
	
	public int delPension(int id) {
		
		return pensionDAO.deletePension(id);
	}
	
	//insert
	public void addPensionAsField(String name, Date date, int day, int headcount, String phoneNumber) {
		
		pensionDAO.insertPensionAsField(name, date, day, headcount, phoneNumber);
	}
	
	//조회
	public Pension getUserData(String name, String phoneNumber) {
		
		
			return pensionDAO.selectUserData(name, phoneNumber);
		
	}
	
	
	
}
