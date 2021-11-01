package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	DepartementRepository depRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);



	
	
	@Override
	public List<Departement> retrieveAllDep() { 
		List<Departement> departements = null; 
		try {
	
			l.info("In retrieveAllDepartments() : ");
			departements = (List<Departement>) depRepository.findAll();  
			for (Departement departement : departements) {
				l.debug("departement +++ : " + departement);
			} 
			l.info("Out of retrieveAllDepartements() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return departements;
	}


	@Override
	public Departement addDep(Departement d) {
		return depRepository.save(d); 
	}

	@Override 
	public Departement updateDep(Departement d) { 
		return depRepository.save(d);
	}
	
	@Override
	public void deleteDep(String id) {
		depRepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Departement retrieveDep(String id) {
		l.info("in  retrieveDepartement id = " + id);
		 
		Departement u =  depRepository.findById(Integer.parseInt(id)).orElse(null);
		l.info("Departement returned : " + u);
		
		return u; 
	}

}
