package edu.jsp.ProjectSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jsp.ProjectSpringBoot.dto.City;
import edu.jsp.ProjectSpringBoot.dto.Country;
import edu.jsp.ProjectSpringBoot.dto.Traveller;
import edu.jsp.ProjectSpringBoot.service.CityService;
import edu.jsp.ProjectSpringBoot.service.CountryService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CityContrller {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private CountryService countryService;
	
	
	
	
	@RequestMapping("/cityAdd")
    public String countryWithCity(@RequestParam("countryId") int TeId,
    		@RequestParam("cityName") List<String> sNames
    		
    	,HttpServletRequest request, Model model){
    	
    	
		System.out.println("City Name"+sNames);
		
		
int id= Integer.valueOf(request.getParameter("countryId"));
    	
    	
System.out.println("List Of All:"+sNames);


    
//       Traveller  traveller=travellerService.findById(id);


      Country country =countryService.findById(id);

    	List<City> staffs=new ArrayList<City>();
    	
    	
    	
    	
    	 for(String secure:sNames) {
    		 
    		 System.out.println("Saved Secure"+secure);
    		 
//    		Country  country=new  Country();
    		 
    		 City city=new City();
    		 
    		 city.setCityName(secure);
//    		country.setCountryName(secure);

    		cityService.saveCity(city);
//    		countryService.saveCountry(country);
    		
    		System.out.println("Country Addesd"+country); 
    		
		staffs.add(city);
//    		 staffs.add(country);
    		 
    		 System.out.println("List Array"+staffs);
    		 
//    		 traveller.setCountries(staffs);

    		   country.setCities(staffs);
   		 
    		   countryService.saveCountry(country);
//    		 travellerService.saveTraveller(traveller);
    		 
    		   System.out.println("Saved Sucessfully");
    		 
    	 }
    
 
    	 return "redirect:/country";
       
    
    
   
	
	}
	
	
	@RequestMapping("/allCity")
	public String getAllCity(Model model) {
		
		System.out.println("Abhijit Shantilal DHumal");
		
		List<City> cities=cityService.getAllCity();
		
		model.addAttribute("city", cities);
		
		
		
		return "getAllCity";
		
		
	}
	
	@RequestMapping("createCity")
	public String saveCity(@ModelAttribute City city) {
		
		cityService.saveCity(city);
		
		return "redirect:/allCity";
	}
	
	
	
	
	@RequestMapping("/updateCity")
	public String updateCity(@RequestParam("cityId")int id,Model model) {
		
		City city=cityService.findById(id);
		
		model.addAttribute("city", city);
		return "updateCity";
		
		
	}
	
	@RequestMapping("/deleteCity")
	public String deleteCity(@RequestParam("cityId") int id) {
		
		cityService.deleteCity(id);
		
		return "redirect:/allCity";
	}
	
	
	@RequestMapping("/addCities")
	public String cityAddToCountry(@RequestParam("countryId") int id,Model model ) {
		
          Country country=new Country();
          
          country.setCountryId(id);
          
          
          model.addAttribute("country", country);
		
		return "addCityToCountry";
		
	}
	
	
	@RequestMapping("/backToCountry")
	public String back() {
		
		return  "redirect:/country";
	}
	
}
