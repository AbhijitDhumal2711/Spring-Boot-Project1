package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.Place;
import edu.jsp.ProjectSpringBoot.repos.PlaceRepos;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepos placeRepos;
	
	
	public Place savePlace(Place place) {
		
		return placeRepos.save(place);
	}
	
	
	
	public List<Place> getAllPlace(){
		return placeRepos.findAll();
	}
	
	
	public Place updatePlace(int id) {
		
		return placeRepos.findById(id).get();
	}
	
	
	public boolean deletePlace(int id) {
		try {
			
			placeRepos.deleteById(id);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
	}
	
}
