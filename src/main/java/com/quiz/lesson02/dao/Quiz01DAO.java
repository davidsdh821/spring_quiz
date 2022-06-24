package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;
@Repository
public interface Quiz01DAO {
	//3
	//Store를 list안에 집어넣음
	public List<Store> selectStoreList();

}
