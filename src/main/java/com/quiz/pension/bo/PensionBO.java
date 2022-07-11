package com.quiz.pension.bo;

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
	
	
	
	
	
}
