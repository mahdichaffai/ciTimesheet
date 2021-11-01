package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface MissionService { 
	 
	List<Mission> retrieveAllMissions(); 
	Mission addMission(Mission m);
	void deleteMission(long id);
	void updateMission(long id, String name);
	Mission retrieveMission(long id);

} 