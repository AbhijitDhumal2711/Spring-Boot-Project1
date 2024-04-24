package edu.jsp.ProjectSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jsp.ProjectSpringBoot.dto.Passport;
import edu.jsp.ProjectSpringBoot.service.PassportService;

@Controller
public class PassportController {

	
	@Autowired
	private PassportService passportService;
	
	
	
	@RequestMapping("/findPass") 
	public String getAllPassport(Model model) {
		
		List<Passport> passports=passportService.getAllPassport();
		
		model.addAttribute("passport", passports);
		
		return "getAllPassport";
	}
	
	@RequestMapping("/updatePassport")
	public String updatePassport(@RequestParam("pId") int id,Model model) {
		
		Passport passport= passportService.updatePassport(id);
		
		model.addAttribute("passport", passport);
		
		
		return  "updatePassport";
	}
	
	@RequestMapping("createPassport")
	 public String savePassport(@ModelAttribute Passport passport) {
		
		
		passportService.savePass(passport);
		
		return "redirect:/findPass";
	}
	
	
	
	
	@RequestMapping("/deletePassport")
	public String deletePassport(@RequestParam("pId")int id) {
		
		passportService.deletePassport(id);
		
		return "getAllPassport";
		
	}
}
