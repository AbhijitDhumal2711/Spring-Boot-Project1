package edu.jsp.ProjectSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jsp.ProjectSpringBoot.dto.Registers;
import edu.jsp.ProjectSpringBoot.service.RegisterService;

@Controller
public class RegistersController {

	@Autowired
	
	private RegisterService registerService;
	
	@RequestMapping("/reg")
	public String registerationForm() {
		
		return "register";
	}
	
	
	@RequestMapping("/registerForm")
	public String registerForm(@ModelAttribute Registers registers) {
		
		registerService.saveRegister(registers);
		
		return "redirect:/reg";
	}
	
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("email")String email,
		
			
			@RequestParam("password")String password     ) {
		
		
		List<Registers> registers =registerService.findByEmailAndPassword(email, password);
		
		
		if(registers!=null && !registers.isEmpty()) {
			
			registers.get(0);
			
			return "redirect:/getAllTraveller";
		}else {
			return "redirect:/about";
		}
		
		
		
		
	}
	
	@RequestMapping("/loginForm")
	
	public String loginPage() {
		
		return "about";
	}
	
	
}
