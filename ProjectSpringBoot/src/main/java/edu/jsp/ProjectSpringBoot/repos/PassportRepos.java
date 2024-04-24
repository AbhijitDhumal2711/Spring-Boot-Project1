package edu.jsp.ProjectSpringBoot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectSpringBoot.dto.Passport;
@Repository
public interface PassportRepos extends JpaRepository<Passport, Integer> {

}
