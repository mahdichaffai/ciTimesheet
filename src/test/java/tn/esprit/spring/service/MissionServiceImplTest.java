package tn.esprit.spring.service;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.MissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	MissionService ms;
	private static final Logger log = LogManager.getLogger(MissionServiceImplTest.class);

	

	@Test
	public void testAddMission() throws ParseException {
		Mission m = new Mission("miss9","des9");
		Mission msn = ms.addMission(m);
		Assert.assertTrue(m.getName().equals("miss9"));
		log.info("mission ajoutée  : "+ m);
} 
	
	@Test
	public void testRetrieveMission() {
		Mission m = ms.retrieveMission(1L);
		Assert.assertEquals(1L, m.getId());
		log.info("retrieveMission : " + m);
	}
//	
	@Test
	public void testDeleteMission() {
		if(ms.retrieveMission(2L) != null)
		ms.deleteMission(2L);
		Assert.assertNull(ms.retrieveMission(2L));		
	}
	/*@Test
	public void testRetrieveAllMissions() {
		List<Mission> msns = ms.retrieveAllMissions();
		log.info("retrieve all missions" + msns);
		
	}*/
  	@Test
	public void testUpdateMission() throws ParseException {
  		 ms.updateMission(1L,"Mission45");
  		Assert.assertTrue(ms.retrieveMission(1L).getName().equals("Mission45"));
		 log.info("updated");
  	}
	
	
}




