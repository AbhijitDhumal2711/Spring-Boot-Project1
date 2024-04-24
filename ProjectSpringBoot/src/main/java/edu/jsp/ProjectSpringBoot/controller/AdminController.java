package edu.jsp.ProjectSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.jsp.ProjectSpringBoot.dto.Traveller;
import edu.jsp.ProjectSpringBoot.service.TravellerService;

@Controller
public class AdminController {

	
	@Autowired
	
	private TravellerService travellerService;
	
	
	@RequestMapping("/admin")
	public String adminInformation(Model model) {
		
		List<Traveller> travellers=travellerService.getAllTraveller();
		
		
		model.addAttribute("details", travellers);
		
		return "admin";
		
	}
	
	
	
}
