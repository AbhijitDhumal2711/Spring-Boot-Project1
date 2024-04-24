package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.Passport;
import edu.jsp.ProjectSpringBoot.repos.PassportRepos;

@Service
public class PassportService {

	@Autowired
	private PassportRepos passportRepos;
	
	
	public Passport savePass(Passport passport) {
		
		return passportRepos.save(passport);
		
	}
	
	
	public List<Passport> getAllPassport(){
		return passportRepos.findAll();
	}
	
	
	
	
	
	public Passport updatePassport(int id) {
		
		return passportRepos.findById(id).get();
	}
	
	
	
	public boolean deletePassport(int id) {
		
		
		try {
			
			
			passportRepos.deleteById(id);
			
			return true;
		} catch (Exception e) {
			
			
			return false;
			// TODO: handle exception
		}
	}
	
	
}
