package com.quiz.pension.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.pension.model.Pension;

@Repository
public interface PensionDAO {

	
	public List<Pension> selectPension();
	
	
	public int deletePension(int id);
	
	//insert
	public void insertPensionAsField(
			@Param("name") String name, 
			@Param("date") Date date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	
	
	
}
