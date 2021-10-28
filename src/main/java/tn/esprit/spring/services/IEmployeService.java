package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;


public interface IEmployeService {
	List<Employe> retrieveAllEmployees(); 
	Employe addEmploye(Employe em);
	void deleteEmploye(String id);
	Employe updateEmploye(Employe em);
	Employe retrieveEmploye(String id);
}
