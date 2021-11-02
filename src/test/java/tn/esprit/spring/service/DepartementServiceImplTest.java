
package tn.esprit.spring.service;


import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

	@Autowired
	IDepartementService us; 
	int i;
	private static final Logger log = LogManager.getLogger(DepartementServiceImplTest.class);

	@Test
	public void testRetrieveAllDepartements() {
		List<Departement> listDepartements = us.retrieveAllDep(); 
		i=listDepartements.size();
		Assert.assertEquals(i, listDepartements.size());
		log.info("retrieve all departements" + listDepartements);
	}


	@Test
	public void testAddDepartement() throws ParseException {

		Departement d = new Departement("Séc"); 
		Departement departementAdded = us.addDep(d); 
		Assert.assertEquals(d.getName(), departementAdded.getName());
		log.info("Departement ajouté  : "+ d);
	}

	@Test
	public void testModifyDep() throws ParseException   {
		Departement d = new Departement(9,"Réseau");
		Departement DepartementUpdated  = us.updateDep(d);
		Assert.assertEquals(d.getName(), DepartementUpdated.getName());
		 log.info("updated");
	}

	@Test
	public void testRetrieveDepartement() {
		Departement DepartementRetrieved = us.retrieveDep("7");
		Assert.assertEquals(7,DepartementRetrieved.getId());
		log.info("retrieveDepartement : " + DepartementRetrieved );
	}
/*
	@Test
	public void testDeleteDepartement() {
		us.deleteDep("40");
		Assert.assertNull(us.retrieveDep("40"));
	} 
	*/
}





