package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.model.Estate;

@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private EstateBO estateBO;
	
	
	//http://localhost/lesson03/quiz02
	@RequestMapping("/lesson03/quiz02/1")
	public Estate ex01(@RequestParam (value = "id", defaultValue = "1") int id) {
		
		
		return estateBO.getRealEstate(id);
	}
//	@RequestMapping("/lesson03/quiz02/2")
//	public Estate ex02() {
//		
//		
//	}
	//http://localhost/lesson03/quiz03/1
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03() {
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int row = estateBO.addEstate(estate);
		return row > 0 ? "입력성공 : 1" : "실패했습니다";
			
	}
	//http://localhost/lesson03/quiz03/2
	@RequestMapping("/lesson03/quiz03/2")
	public String quiz03_2(@RequestParam("realtor_id") int realtorId) {
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		
		int row = estateBO.addEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공: " + row;
	}
	
	
	
	
}
