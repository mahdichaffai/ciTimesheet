package tn.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Mission;


@Repository
public interface MissionRepository extends  CrudRepository<Mission, Long> {
	
	@Query(value = "SELECT * FROM Mission where id = ?1", nativeQuery = true) Mission findMissionById(Long id);	
	@Transactional
	@Modifying
	@Query("UPDATE Mission m " + "SET m.name = ?1 WHERE m.id = ?2")void updateM(String name , long  id);

}