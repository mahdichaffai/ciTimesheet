package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;


public interface IEmployeService {
	List<Employe> retrieveAllEmployees(); 
	Employe addEmploye(Employe em);
	
	Employe updateEmploye(Employe em);
	Employe retrieveEmploye(Long id);
	void deleteEmploye(Long id);
}
