package tn.esprit.spring.services;
import java.util.List;
import tn.esprit.spring.entities.MissionExterne;
public interface MissionExterneService { 
	MissionExterne addMissionExterne(MissionExterne me);
	void deleteMissionExterne(String id);
	MissionExterne updateMissionExterne(MissionExterne me);
	MissionExterne retrieveMissionExterne(String id);
	//i'm here
	List<MissionExterne> retrieveAllMissionExterne();
} 
