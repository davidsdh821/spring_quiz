package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.favorite;

@Repository
public interface FavoriteDAO {

	public void insertFavoriteAsField(
			@Param("name") String name,
			@Param("url") String url);
	
	public List<favorite> selectFavorite();
	
	
	public favorite selectFavoriteByUrl(String url);
	
	
	public int deleteFarvorite(int id);
}
