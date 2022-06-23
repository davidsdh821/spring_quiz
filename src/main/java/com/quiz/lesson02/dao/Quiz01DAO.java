package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;
@Repository
public interface Quiz01DAO {
	//3
	//이곳에서 Store에서 가져온 것을 리스트 안에 넣음 id,전화번호 형식까지 전부 들어가진다.
	public List<Store> selectStoreList();

}
