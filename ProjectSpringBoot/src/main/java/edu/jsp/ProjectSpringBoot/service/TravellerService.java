package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.Traveller;
import edu.jsp.ProjectSpringBoot.repos.TravellerRepos;

@Service
public class TravellerService {

	
	@Autowired
	private TravellerRepos travellerRepos;
	
	
	public Traveller saveTraveller(Traveller traveller) {
		
		return travellerRepos.save(traveller);
	}
	
	public List<Traveller> getAllTraveller(){
		
		return travellerRepos.findAll(Sort.by(Sort.Direction.DESC,"TId"));
	}
	
	
	public boolean deleteTraveller(int id) {
		
		try {
			 travellerRepos.deleteById(id);
			 
			 return true;
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
		 
	}
	
	
	public Traveller updateTraveller(int id) {
		
		
		
		return travellerRepos.findById(id).get();
	}
	
	
	public Traveller findById(int id) {
	 return travellerRepos.findById(id).get();
	}
	
	public Traveller updateAllTraveller(Traveller traveller) {
		
		return travellerRepos.save(traveller);
	}
	
	
}
