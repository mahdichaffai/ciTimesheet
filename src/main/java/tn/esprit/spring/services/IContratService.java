package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
	List<Contrat> retrieveAllContrats(); 
	Contrat addContrat(Contrat c);
	void deleteContrat(String reference);
	Contrat updateContrat(Contrat c);
	Contrat retrieveContrat(String reference);
}
