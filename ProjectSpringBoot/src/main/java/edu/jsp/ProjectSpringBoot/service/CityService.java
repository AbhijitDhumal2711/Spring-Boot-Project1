package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.City;
import edu.jsp.ProjectSpringBoot.repos.CityRepos;

@Service
public class CityService {

	
	@Autowired
	private CityRepos cityRepos;
	
	
	public City saveCity(City city) {
		return cityRepos.save(city);
	}
	
	
	public List<City> getAllCity(){
		return cityRepos.findAll();
	}
	
	
	public City findById(int id) {
		
		
		return cityRepos.findById(id).get();
		
	}
	
	
	
	public City updateCity(int id) {
		
		return cityRepos.findById(id).get();
	}
	
	
	public boolean deleteCity(int id) {
		
		try {
			
			cityRepos.deleteById(id);
			return true;
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
		
	}
	
}
