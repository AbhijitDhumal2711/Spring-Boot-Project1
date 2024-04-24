package edu.jsp.ProjectSpringBoot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.Traveller;


@Repository
public interface TravellerRepos extends JpaRepository<Traveller, Integer> {

}
