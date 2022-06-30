package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class RealtorController {
	@Autowired
	RealtorBO realtorBO;
	
	//http://localhost/lesson04/quiz02/1
	@RequestMapping("/1")
	public String ex01_1() {
		
		
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add_realtor")
	public String addrealtor(@ModelAttribute Realtor realtor, Model model) {
		
		//db = insert = > id key
		realtorBO.addRealtor(realtor);
		//db select
		realtor =  realtorBO.getLastRealtor(realtor.getId()); //my baits가 id를 채워 넣었다.
		//model 담고
	
		model.addAttribute("result", realtor); 
		
		//return
		return "lesson04/lastRealtor";
	} //이따 다시 풀기
	

	
}
