
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EntrepriseServiceImplTest {
		
		static Entreprise addedEntreprise ;
		@Autowired
		IEntrepriseService us; 
	
		@Test
		public void DtestRetrieveAllEntrprises() {
			List<Entreprise> listEntreprises = us.retrieveAllEntreprise(); 
			// if there are 7 users in DB : 
			Assert.assertTrue(1<=listEntreprises.size());
		}
		
		
		@Test
		public void AtestAddEntreprise() throws ParseException {
			
			Entreprise u = new Entreprise("Delice", "SARL"); 
			Entreprise entrepriseAdded = us.addEntreprise(u); 
			addedEntreprise = entrepriseAdded;
			Assert.assertNotNull(entrepriseAdded);
		}
	 
		@Test
		public void BtestModifyEntreprise() throws ParseException   {

			Entreprise u = addedEntreprise;
			u.setName("Poulina");
			Entreprise entrepriseAdded = us.updateEntreprise(u); 
			Assert.assertEquals(u.getName(), entrepriseAdded.getName());
		}
	
		@Test
		public void CtestRetrieveEntreprise() {
			Entreprise entrepriseRetrieved = us.retrieveEntreprise(addedEntreprise.getId().toString()); 
			Assert.assertNotNull(entrepriseRetrieved);
		}
		
		@Test
		public void EtestDeleteEntreprise() {
			us.deleteEntreprise(addedEntreprise.getId().toString());
			Assert.assertNull(us.retrieveEntreprise(addedEntreprise.getId().toString()));
		}
		
 
}





