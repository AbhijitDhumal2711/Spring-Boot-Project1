package edu.jsp.ProjectSpringBoot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.Country;

@Repository
public interface CountryRepos  extends JpaRepository<Country, Integer>{

	
	
	
	
}
