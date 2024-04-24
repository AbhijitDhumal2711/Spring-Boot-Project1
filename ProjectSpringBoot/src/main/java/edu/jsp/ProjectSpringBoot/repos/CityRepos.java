package edu.jsp.ProjectSpringBoot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.City;

@Repository
public interface CityRepos extends JpaRepository<City, Integer> {

}
