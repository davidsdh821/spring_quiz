package com.quiz.pension.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.pension.model.Pension;

@Repository
public interface PensionDAO {

	
	public List<Pension> selectPension();
	
}
