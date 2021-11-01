package tn.esprit.spring.services;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.repository.MissionExterneRepository;
@Service
public class MissionExterneServiceImpl implements MissionExterneService {
	@Autowired
	MissionExterneRepository meRepository;
	private static final Logger l = LogManager.getLogger(MissionExterneServiceImpl.class);
	@Override
	public List<MissionExterne> retrieveAllMissionExterne() { 
		List<MissionExterne> missionexternes = null; 
		try {
			l.info("In retrieveAllMissionExterne() : ");
			missionexternes = (List<MissionExterne>) meRepository.findAll();  
			for (MissionExterne missionexterne : missionexternes) {
				l.debug("missionexterne +++ : " + missionexterne);
			} 
			l.info("Out of retrieveAllMissionExterne() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMissionExterne() : " + e);
		}
		return missionexternes;
	}
	@Override
	public MissionExterne addMissionExterne(MissionExterne me) {
		return meRepository.save(me); 
	}
	@Override 
	public MissionExterne updateMissionExterne(MissionExterne me) { 
		return meRepository.save(me);
	}
	@Override
	public void deleteMissionExterne(String id) {
		meRepository.deleteById(Integer.parseInt(id));
	}
	@Override
	public MissionExterne retrieveMissionExterne(String id)  {
		l.info("in  retrieveMissionExterne id = " + id);
		MissionExterne d =  meRepository.findById(Integer.parseInt(id)).orElse(null); 
		l.info("MissionExterne returned : " + d);
		return d; 
	}
}
