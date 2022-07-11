package com.quiz.pension;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.FavoriteBO;
import com.quiz.pension.bo.PensionBO;
import com.quiz.pension.model.Pension;

@RequestMapping("/log")
@Controller
public class PensionController {
	@Autowired
	PensionBO pensionBO;
	
	
	//http://localhost/log/pensionList
	@GetMapping("/pensionList")
	public String pensionlist(Model model) {
		List<Pension> result = pensionBO.getPension();
		
		model.addAttribute("result", result);
		
		return "sites/listPension";
		
	}
	
	//POST: 회원가입 할때 주로 쓴다
	//GET: 데이터를 조회하거나 가져올때 주로 쓴다.
	//PUT: 수정할때 주로 쓴다. @PutMapping
	//DELETE: 제거할 때 주로 쓴다 @DeleteMapping으로 사용할 수 있다.
	//이런식의 디테일하게 설계하는 것을 RESTFUL API라고 한다. 보통의 경우에는 POST와 GET만 사용하니 알아만 두자
	@ResponseBody
	@PostMapping("/del_btn")
	public Map<String, Object> delList(
			@RequestParam("id") int id
			) {
		
		int row = pensionBO.delPension(id);
		
		Map<String, Object> map = new HashMap<>();
		
		if(row > 0) {
			map.put("del", "success");
		} else {
			map.put("del", "failed");
		}
		
		return map;
	}
	
	//http://localhost/log/addData_view
	@RequestMapping("/addData_view")
	public String add_data_view() {

		return "sites/reservationPension";
	}
	
	
	@ResponseBody
	@PostMapping("/addData")
	public Map<String, Object> add_data(
			@RequestParam("name") String name,
			@RequestParam("date") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		
		//insert db
		pensionBO.addPensionAsField(name, date, day, headcount, phoneNumber);
		
		//map에 성공여부 담기
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		result.put("result_code", 1);		
		
		
		return result;
	}
	
	
	
	
}
