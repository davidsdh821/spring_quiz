package com.quiz.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.Realtor;

@Repository
public interface RealtorDAO {
	
	public void inesrtRealtorById(Realtor realtor); //여기도 마찬가지로 가져옴
	
	public Realtor selectLastRealtor(int id);
}
