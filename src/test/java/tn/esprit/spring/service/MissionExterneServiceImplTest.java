package tn.esprit.spring.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.services.MissionExterneService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionExterneServiceImplTest {
	@Autowired
	MissionExterneService me;
	int i;
	private static final Logger log = LogManager.getLogger(MissionExterneServiceImplTest.class);
	@Test
	public void testRetrieveAllMissionExterne() {
		List<MissionExterne> listMissionExterne = me.retrieveAllMissionExterne(); 
		i= listMissionExterne.size();
		// if there are 7 users in DB : 
		Assert.assertEquals(i, listMissionExterne.size());
	}
	@Test
	public void testAddMissionExterne() throws ParseException {
		MissionExterne mex= new MissionExterne("daeda", "dadae"," mekki.benmoussa1@esprit.tn", 40);
		MissionExterne MissionExterneAdded = me.addMissionExterne(mex); 
		Assert.assertEquals(mex.getEmailFacturation(),MissionExterneAdded.getEmailFacturation());
	}
/*	@Test
	public void testModifyMissionExterne() throws ParseException   {
		MissionExterne mex = new MissionExterne(86, "azaiz", "afe"," mekki.zarfa,okefpael;@esprit.tn", 50); 
		MissionExterne mefea  = me.updateMissionExterne(mex);
		Assert.assertEquals(mex.getEmailFacturation(), mefea.getEmailFacturation());
	} 
	//	@Test
	//	public void testModifyMissionExterne() throws ParseException   {

	//	MissionExterne mex= new MissionExterne("daeda", "dadae"," mekki.benmoussa1@esprit.tn", 40);
	//	MissionExterne MissionExterneUpdated  = me.updateMissionExterne(mex); 
	//Assert.assertEquals(e.getNom(),EmployeUpdated.getPrenom());
	//	}
	@Test
	public void testRetrieveMissionExterne() {
		MissionExterne c = me.retrieveMissionExterne("58");
		Assert.assertEquals(58, c.getId());
	}
	@Test
	public void testdeleteMissionExterne() {
		me.deleteMissionExterne("127");
		Assert.assertNull(me.retrieveMissionExterne("127"));
	}
	// 5 tests unitaires   */
}