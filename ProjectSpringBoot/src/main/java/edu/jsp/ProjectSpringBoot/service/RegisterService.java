package edu.jsp.ProjectSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ProjectSpringBoot.dto.Registers;
import edu.jsp.ProjectSpringBoot.repos.RegisterRepos;

@Service
public class RegisterService  {

	
	@Autowired
	
	private RegisterRepos registerRepos;
	
	public Registers saveRegister(Registers registers) {
		
		return registerRepos.save(registers);
	}
	
	
	public List<Registers> findByEmailAndPassword(String email,String password) {
		
		return registerRepos.findByEmailAndPassword(email, password);
	}
}
