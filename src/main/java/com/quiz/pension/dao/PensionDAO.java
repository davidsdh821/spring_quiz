package com.quiz.pension.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.pension.model.Pension;

@Repository
public interface PensionDAO {

	
	public List<Pension> selectPension();
	
	
	public int deletePension(int id);
	
	//insert
	public void insertPensionAsField(String name, Date date, int day, int headcount, String phoneNumber);
	
	
	
	
}
