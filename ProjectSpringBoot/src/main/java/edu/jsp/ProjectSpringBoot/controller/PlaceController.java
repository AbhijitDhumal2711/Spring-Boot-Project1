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
import edu.jsp.ProjectSpringBoot.dto.Place;
import edu.jsp.ProjectSpringBoot.service.CityService;
import edu.jsp.ProjectSpringBoot.service.PlaceService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PlaceController {

	
	@Autowired 
	
	private PlaceService placeService;
	
	@Autowired
	private CityService cityService;
	
	
	@RequestMapping("/placeAdd")
    public String cityWithPlace(@RequestParam("cityId") int TeId,
    		@RequestParam("placeName") List<String> sNames
    		
    	,HttpServletRequest request, Model model){
    	
    	
		System.out.println("Place Name"+sNames);
		
		
int id= Integer.valueOf(request.getParameter("cityId"));
    	
    	
System.out.println("List Of All:"+sNames);


       City  city=cityService.findById(id);


    	List<Place> staffs=new ArrayList<Place>();
    	
    	
    	
    	
    	 for(String secure:sNames) {
    		 
    		 System.out.println("Saved Secure"+secure);
    		 
    		 Place place=new Place();
    		 
    		 place.setPlaceName(secure);

    		 placeService.savePlace(place);
    		 
    		cityService.saveCity(city);

    		System.out.println("Country Addesd"+city); 
    		
    		staffs.add(place);
    		
    		 System.out.println("List Array"+staffs);
    		 
   		 city.setPlaces(staffs);
   		 
   		 cityService.saveCity(city);
    		 
    		   System.out.println("Saved Sucessfully");
    		 
    	 }
    
 
    	 return "redirect:/allCity";
       
    
    
    }

	
	@RequestMapping("/findPlace")
	public String getAllPlace(Model model) {
		
		List<Place> place=placeService.getAllPlace();
		
		model.addAttribute("place", place);
		
		
		return "getAllPlace";
	}
	
	@RequestMapping("/updatePlace")
	public String updatePlace(@RequestParam("placeId")int id,Model model) {
		
		Place place=placeService.updatePlace(id);
		
		model.addAttribute("place", place);
		
		return "updatePlace";
	}
	
	@RequestMapping("/deletePlace")
	public String deletePlace(@RequestParam("placeId") int id) {
		
		
		placeService.deletePlace(id);
		
		return "redirect:/findPlace";
	}
	
	
	@RequestMapping("/createPlace")
	public String saveAllPlace(@ModelAttribute Place place) {
		
		placeService.savePlace(place);
		
		return "redirect:/findPlace";
	}
	
	
	@RequestMapping("/places")
	public String addPlaceToCity(@RequestParam("cityId") int id,Model model) {
		
		City city=new City();
		city.setCityId(id);
		
		model.addAttribute("city", city);
		
		
		
		return "addPlaceToCity";
		
		
		
	}
	
	
	@RequestMapping("/backToCity")
	public String back() {
		
		return  "redirect:/allCity";
	}
	
}
