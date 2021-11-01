package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.MissionExterne;
@Repository
public interface MissionExterneRepository  extends CrudRepository<MissionExterne, Integer>{
	
}