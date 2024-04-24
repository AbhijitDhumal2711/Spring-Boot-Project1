package edu.jsp.ProjectSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.jsp.ProjectSpringBoot.dto.Country;
import edu.jsp.ProjectSpringBoot.dto.Traveller;
import edu.jsp.ProjectSpringBoot.service.CountryService;
import edu.jsp.ProjectSpringBoot.service.TravellerService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CountryController {

	
    @Autowired
    
    private CountryService countryService;
	
	
	
	@Autowired
	
	private TravellerService travellerService;
	
	@RequestMapping("/countryAdd")
    public String TravellerWithCountry(@RequestParam("TId") int TeId,
    		@RequestParam("countryName") List<String> sNames
    		
    	,HttpServletRequest request, Model model){
    	
    	
		System.out.println("Country Name"+sNames);
		
		
int id= Integer.valueOf(request.getParameter("TId"));
    	
    	
System.out.println("List Of All:"+sNames);


    
       Traveller  traveller=travellerService.findById(id);


    	List<Country> staffs=new ArrayList<Country>();
    	
    	
    	
    	
    	 for(String secure:sNames) {
    		 
    		 System.out.println("Saved Secure"+secure);
    		 
    		Country  country=new  Country();
    		 
    		 
    		country.setCountryName(secure);

    		
    		countryService.saveCountry(country);
    		
    		System.out.println("Country Addesd"+country); 
    		
		
    		 staffs.add(country);
    		 
    		 System.out.println("List Array"+staffs);
    		 
    		 traveller.setCountries(staffs);

    		   
   		 
    		 travellerService.saveTraveller(traveller);
    		 
    		   System.out.println("Saved Sucessfully");
    		 
    	 }
    
 
    	 return "redirect:/getAllTraveller";
       
    
    
    }
   

	@RequestMapping("/country")
	public String getAllCountry(org.springframework.ui.Model model) {
		
		
		List<Country> countries=countryService.getAllContry();
		
		model.addAttribute("country", countries);
		
		System.out.println("Countries"+countries);
		
		
		
		return "getAllCountry";
	}
	
	
	@RequestMapping("/createCountry")
	public String saveCountry(@ModelAttribute Country country) {
		
		
		countryService.saveCountry(country);
		
		return "redirect:/country";
		
	}
	
	
	
	@RequestMapping("/updateCountry")
	public String updateCountry(@RequestParam("countryId") int countryId,Model model) {
		
		
		Country country=countryService.findById(countryId);
		
		model.addAttribute("country", country);
		
		
		return "updateCountry";
	}
	
	
	@RequestMapping("deleteCountry")
	public String deleteCountry(@RequestParam("countryId") int id) {
		
		countryService.deleteCountry(id);
		
		return "redirect:/country";
	}
	
	@RequestMapping("/backToTraveller")
	public String back() {
		
		return  "redirect:/getAllTraveller";
	}
	
	
}
