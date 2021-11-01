package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	@Autowired
	IContratService cs;
	
	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.retrieveAllContrats(); 
		// if there are 7 contrats in DB : 
		Assert.assertEquals(11, listContrats.size());
	}
	
	
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-11-15");
		Contrat c = new Contrat(d, "CDI", 5000); 
		Contrat contratAdded = cs.addContrat(c); 
		Assert.assertEquals(c.getTypeContrat(), contratAdded.getTypeContrat());
	}
 
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-01-01");
		Contrat c = new Contrat(7L, d, "CDN", 5000); 
		Contrat contratUpdated  = cs.updateContrat(c); 
		Assert.assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
	}

	@Test
	public void testRetrieveContrat() {
		Contrat contratRetrieved = cs.retrieveContrat("1"); 
		Assert.assertEquals(1L, contratRetrieved.getReference().longValue());
	}
	
	@Test
	public void testDeleteContrat() {
		cs.deleteContrat("13");
		Assert.assertNull(cs.retrieveContrat("13"));
	}
	
	
}
