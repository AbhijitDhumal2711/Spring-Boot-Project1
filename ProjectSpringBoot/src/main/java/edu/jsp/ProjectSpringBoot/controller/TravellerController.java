package edu.jsp.ProjectSpringBoot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jsp.ProjectSpringBoot.dto.Passport;
import edu.jsp.ProjectSpringBoot.dto.Traveller;
import edu.jsp.ProjectSpringBoot.service.PassportService;
import edu.jsp.ProjectSpringBoot.service.TravellerService;
import jakarta.servlet.http.HttpSession;

@Controller
public class TravellerController {

	@Autowired
	private TravellerService travellerService;
	
	@Autowired
	private PassportService service;
	
	
	
	@RequestMapping(value = "/about", method =RequestMethod.GET)
	public String about(Model model) {
		
	
		model.addAttribute("msg", "Sucess");
		

		
		System.out.println("My Name Abhijit Shantilal Dhumal");
		
		return "about";
	}
	
	
	
	
	
	
	@RequestMapping("/")
	public String register(Model model) {
		
		
		model.addAttribute("s", "My Name");
		
		model.addAttribute("name", "Abhijit Shantilal Dhumal");
		
		model.addAttribute("cricket", "Dhoni");
		
		
		return "register";
	}
	
	
	
	@RequestMapping("/addEmp")
	public String addTraveller(Model model) {
		
		return "addEmp";
		
	}
	
	
	
//	@RequestMapping("/passport")
//	public String passportForm(@RequestParam("TId") int id,Model model) {
//		
//		return "addPassport";
//		
//	}
	
	@RequestMapping("/addTraveller")
	public String addTravellers(Model model) {
		
		return "index";
		
	}
	

	@RequestMapping("/createTraveller")
	public String createTraveller(@ModelAttribute Traveller traveller,
			HttpSession session
			
			) {
		
		
		travellerService.saveTraveller(traveller);
		
		session.setAttribute("msg", "Sucessfully Added");
		System.out.println(traveller);
		return "redirect:/getAllTraveller";
		
	}
	
	
	@GetMapping("/getAllTraveller")
	public String getAllTraveller(Model model) {
		
		List<Traveller> travellers=travellerService.getAllTraveller();
		
		System.out.println(travellers);
		
		model.addAttribute("traveller", travellers);
		
		return "getAllTraveller";
		
	}
	
	@RequestMapping("/delete")
	public String deleteTraveller(@RequestParam("TId") int id) {
		
		travellerService.deleteTraveller(id);
		
		return "redirect:/getAllTraveller";
	}
	
	
	@RequestMapping("/edit")
	public String updateTraveller(@RequestParam("TId") int id, Model model) {
		
		Traveller traveller= travellerService.updateTraveller(id);
		
		model.addAttribute("traveller", traveller);
		
		
//      Traveller traveller2=new Traveller();
//      
//      traveller2.setFullName(traveller.getFullName());
//      
//      traveller2.setAddress(traveller.getAddress());
//      
//      traveller2.setEmail(traveller.getEmail());
//      
//      traveller2.setPassword(traveller.getPassword());
//      
//      model.addAttribute("traveller2", traveller2);
//      
		return "updateTraveller";
	}

	
	

	
	
	
	
	
	@RequestMapping("passport")
	public String addPassport(@RequestParam("TId") int id, Model model,
			@ModelAttribute Passport passport
			
			) {
		
		Traveller traveller= travellerService.findById(id);
		
		traveller.setPassport(passport);
		
//		service.savePass(passport);
		
		travellerService.updateAllTraveller(traveller);
		
		
		
		model.addAttribute("traveller", traveller);
		
		
//      Traveller traveller2=new Traveller();
//      
//      traveller2.setFullName(traveller.getFullName());
//      
//      traveller2.setAddress(traveller.getAddress());
//      
//      traveller2.setEmail(traveller.getEmail());
//      
//      traveller2.setPassword(traveller.getPassword());
//      
//      model.addAttribute("traveller2", traveller2);
      
		
		return "redirect:/getAllTraveller";
	}

	

	@RequestMapping("/p")
	public String fromPassport(Model model) {
		
		return "addPassport";
		
	}


	
	@GetMapping("/city")
	public String getCity(Model model) {
		
		List<Traveller> travellers=travellerService.getAllTraveller();
		
		System.out.println(travellers);
		
		model.addAttribute("traveller", travellers);
		
		return "addCity";
		
	}
	
	
}
