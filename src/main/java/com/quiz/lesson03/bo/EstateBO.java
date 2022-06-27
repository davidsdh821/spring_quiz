package com.quiz.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.EstateDAO;
import com.quiz.lesson03.model.Estate;

@Service
public class EstateBO {
	
	@Autowired
	private EstateDAO estateDAO;
	
	public Estate getRealEstate(int id) {
		
		return estateDAO.selectRealEstate(id);
	}
	public int addEstate(Estate estate) {
		return estateDAO.insertEstate(estate);
	}
	
	public int addEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		
		return estateDAO.insertEstateAsField(realtorId, address, area, type, price, rentPrice);
	}

}
