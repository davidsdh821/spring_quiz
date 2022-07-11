package com.quiz.pension;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.pension.bo.PensionBO;
import com.quiz.pension.model.Pension;

@RequestMapping("/log")
@Controller
public class PensionController {
	@Autowired
	PensionBO pensionBO;
	
	
	//http://localhost/pension/log/pensionList
	@GetMapping("/pensionList")
	public String pensionlist(Model model) {
		List<Pension> result = pensionBO.getPension();
		
		model.addAttribute("result", result);
		
		return "sites/listPension";
		
	}
	
	
	
	
	
}
