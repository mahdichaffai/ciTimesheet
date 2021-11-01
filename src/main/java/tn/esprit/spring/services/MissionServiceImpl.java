package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;

import tn.esprit.spring.repository.MissionRepository;


@Service
public class MissionServiceImpl implements MissionService{
@Autowired

MissionRepository missionRepository;

@Override
public List<Mission> retrieveAllMissions() {
	return (List<Mission>) missionRepository.findAll();	
}

@Override
public Mission addMission(Mission m) {
	//Date cdate = new Date();
	//c.setDatedebut(cdate);
	missionRepository.save(m) ;
	return m;
}

@Override
public void deleteMission(long id) {
	missionRepository.deleteById(id);
	
}

@Override
public void updateMission(long id, String name) {
	missionRepository.updateM(name, id);
	
	
}

@Override
public Mission retrieveMission(long id) {
	return	missionRepository.findById(id).orElse(null);
}

//@Override
//public Contrat retrieveContratByEmploye(long empId) {
	//return	contratRepository.findContartByEmployee(empId);
//}
	

}