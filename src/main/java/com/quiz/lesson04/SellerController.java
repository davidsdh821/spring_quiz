package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class SellerController {
	@Autowired
	private SellerBO sellerBO;
	
	//http://localhost/lesson04/quiz01/1
	@RequestMapping("/1")
	public  String addSeller() {
		
		return "lesson04/addSeller";
	
	}
	//http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String addSeller_info(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl" , required=false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		
		return "lesson04/after_add_seller";
	}
	//http://localhost/lesson04/quiz01/2
	@GetMapping("/2")
	public String getSeller_1(Model model) {
		Seller seller = sellerBO.getLastSeller();
		
		model.addAttribute("result", seller);

		return "lesson04/getSeller";
		
	}
	///http://localhost/lesson04/quiz01/3
	@GetMapping("/3")
	public String getSeller_2(Model model,
			@RequestParam(value =  "id", required=false) Integer id) {
		sellerBO.getSeller(id);
		Seller seller;
		if(id == null) {
			seller = sellerBO.getLastSeller();
		} else {
			seller = sellerBO.getSeller(id);
		}
		
		model.addAttribute("result", seller);
		
		
		return "lesson04/getSeller";
	}

	
}
