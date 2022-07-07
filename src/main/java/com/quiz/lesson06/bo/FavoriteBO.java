package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.FavoriteDAO;
import com.quiz.lesson06.model.favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	FavoriteDAO favoriteDAO;
	
	public void addFavoriteAsField(String name, String url) {
		
		
		favoriteDAO.insertFavoriteAsField(name, url);
	}
	
	public List<favorite> getFavorite() {
		
		return favoriteDAO.selectFavorite();
	}
	
	

}
