package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.Country;
import edu.jsp.ProjectSpringBoot.repos.CountryRepos;

@Service
public class CountryService {

	@Autowired
	private CountryRepos countryRepos;
	
	
	public Country saveCountry(Country country) {
		return countryRepos.save(country);
	}
	
	
	public List<Country> getAllContry(){
		return countryRepos.findAll(Sort.by(Sort.Direction.DESC,"countryId"));
	}
	
	
	public Country findById(int id) {
		
		return countryRepos.findById(id).get();
	}
	
	
	public boolean deleteCountry(int id) {
		
		try {
			
			countryRepos.deleteById(id);
			return true;
			
			
		} catch (Exception e) {
			
			return false;
			// TODO: handle exception
		}
	}
	
}
