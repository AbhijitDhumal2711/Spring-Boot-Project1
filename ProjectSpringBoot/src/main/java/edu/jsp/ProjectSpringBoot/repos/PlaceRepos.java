package edu.jsp.ProjectSpringBoot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.Place;

@Repository
public interface PlaceRepos  extends JpaRepository<Place, Integer> {

}
