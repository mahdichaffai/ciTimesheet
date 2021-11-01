package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements IEmployeService {
	private static final Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	@Autowired
	EmployeRepository empl;
	@Override
	public List<Employe> retrieveAllEmployees() {
		List<Employe> Emp = null; 
		try {
			
			l.info("In retrieveAllEmployees() : ");
			Emp = (List<Employe>) empl.findAll();  
			for (Employe Employe : Emp) {
				l.debug("Employe +++ : " + Employe);
			} 
			l.info("Out of retrieveAllEmployees() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmployees() : " + e);
		}

		return Emp;

	}
	@Override
	public Employe addEmploye(Employe em) {
		// TODO Auto-generated method stub
		return  empl.save(em);
	}
	@Override
	public void deleteEmploye(Long id) {
		// TODO Auto-generated method stub
		empl.deleteById(id);
		
	}
	@Override
	public Employe updateEmploye(Employe em) {
		// TODO Auto-generated method stub
		return  empl.save(em);
	}
	@Override
	public Employe retrieveEmploye(Long id) {
		// TODO Auto-generated method stub
		l.info("in  retrieveEmploye id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).get();
		//int i = 1/0; 
		Employe e =  empl.findById(id).orElse(null); 
		//Employe e =  empl.findById(Long.parseLong(id)).get();
		l.info("Employe returned : " + e);
		return e; 
	}
	
}
