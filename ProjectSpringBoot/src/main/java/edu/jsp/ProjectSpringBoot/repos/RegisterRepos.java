package edu.jsp.ProjectSpringBoot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.Registers;

@Repository
public interface RegisterRepos extends JpaRepository<Registers, Integer> {

	
	public List<Registers> findByEmailAndPassword(String email,String password);
	
	
}
