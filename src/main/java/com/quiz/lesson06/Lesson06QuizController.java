package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.lesson06.model.favorite;

@RequestMapping("/lesson06")
@Controller
public class Lesson06QuizController {

	@Autowired
	FavoriteBO favoriteBO;
	
	
	//http://localhost/lesson06/quiz01
	@RequestMapping("/quiz01")
	public String quiz01() {
		
		return "lesson06/addFavorite";
	}
	//url 중복 확인 - ajax로 온 요청
	@ResponseBody
	@PostMapping("/is_duplication_url")
	public Map<String, Boolean> isDuplicationUrl(
			@RequestParam("url") String url
			) {
		//select 중복 확인 , null체크 방식(가져와지면 중복, 값이 null이면 중복 아닌것으로 판단)
		
		
		
		//map에 결과를 담기, json String
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", true);
		//return map
		
		return result;
	}
	@ResponseBody
	@PostMapping("/del_List") 
	public Map<String, Object> delList(
			@RequestParam("id") int id
			) {

		int row = favoriteBO.delFarvorite(id);
		
		Map<String, Object> map = new HashMap<>();
		
		if(row > 0) { //data.result값을 정해줌
			map.put("result", "success");
		} else {
			map.put("result", "failed");
		}
		
		
		
		return map;
		
	}
	
	
	
	
	//ajax로 들어오는 요청은 반드시 reponsebody가 붙어있어야 하고 string을 return해야한다
	@ResponseBody
	@PostMapping("/quiz01_2")
	public String quiz01_2(@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		favoriteBO.addFavoriteAsField(name, url);
		
		
		return "입력성공";
	}
	//두번째 방식
	//map과 api의 원리를 사용하는 방식, 가능하면 이방식을 쓰자
	//위의 방식처럼 string으로 만들어도 작동되지만 map을 사용하는 이유는 에러코드를 상세하게 전송하기 위해서이다
//	public Map<String, Object> addFavorite(
//			@RequestParam("name") String name,
//			@RequestParam("url") String url
//			) {
//		//insert db
//		favoriteBO.addFavoriteAsField(name, url);
//		//성공여부를 map에 담는다
//		//{"result": "success"}
//		 Map<String, Object> result = new HashMap<>();
//		 result.put("result", "success");
//		 result.put("result_code", 1);
//		 
//		//맵 리턴 
//		return result;
//	}
	
	//http://localhost/lesson06/quiz01_3
	@GetMapping("/quiz01_3") 
	public String quiz01_3(Model model) {
		List<favorite> result = favoriteBO.getFavorite();
		
		model.addAttribute("result", result);
		
		
		return "lesson06/viewFavorite";
	}
	
	
}
