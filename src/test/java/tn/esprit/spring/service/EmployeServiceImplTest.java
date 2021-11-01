package tn.esprit.spring.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import org.junit.runners.MethodSorters;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeServiceImplTest {
	static Employe EmployeAdded ;
	@Autowired
	IEmployeService es;
	@Test
	public void testRetrieveAllEmployees() {
		List<Employe> listEmployees = es.retrieveAllEmployees(); 
		// if there are 7 users in DB : 
		Assert.assertTrue(1<= listEmployees.size());
	}
	@Test
	public void testAddEmploye() throws ParseException {
		Employe e= new Employe("sarra", "sarra", "sarra.zribi@esprit.tn", "xxxxx",true, Role.INGENIEUR);
		Employe EmployeAdded = es.addEmploye(e); 
		Assert.assertEquals(e.getNom(),EmployeAdded.getPrenom());
	}
 
	@Test
	public void testModifyEmploye() throws ParseException   {

		Employe e= new Employe("sarra", "sarraZr", "sarra.zribi@esprit.tn", "yyyy",false, Role.INGENIEUR);
		Employe EmployeUpdated  = es.updateEmploye(e); 
		//Assert.assertEquals(e.getNom(),EmployeUpdated.getPrenom());
	}

//	@Test
//	public void testRetrieveEmploye() {
////		Employe EmployeRetrieved = es.retrieveEmploye("4") ;
////		Assert.assertEquals(4L, EmployeRetrieved.getId().longValue());
//		Employe EmployeRetrieved = es.retrieveEmploye(EmployeAdded.getId().toString()); 
//		Assert.assertNotNull(EmployeRetrieved);
//	}
//	
//	@Test
//	public void testDeleteEmploye() {
//		es.deleteEmploye("EmployeAdded.getId().toString()");
//	   Assert.assertNull(es.retrieveEmploye(EmployeAdded.getId().toString()));
//	}
	
	// 5 tests unitaires  

	
}
