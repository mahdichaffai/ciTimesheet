package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);



	
	
	@Override
	public List<Entreprise> retrieveAllEntreprise() { 
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In retrieveAllEntreprises() : ");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise entreprise : entreprises) {
				l.debug("entreprise +++ : " + entreprise);
			} 
			l.info("Out of retrieveAllEntreprises() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEntreprises() : " + e);
		}

		return entreprises;
	}


	@Override
	public Entreprise addEntreprise(Entreprise u) {
		return entrepriseRepository.save(u); 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise u) { 
		return entrepriseRepository.save(u);
	}

	@Override
	public void deleteEntreprise(String id) {
		entrepriseRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		l.info("in  retrieveUser id = " + id);
		Entreprise u =  entrepriseRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		//User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("user returned : " + u);
		return u; 
	}

}
