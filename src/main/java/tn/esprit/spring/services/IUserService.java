package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService { 
	 
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	User updateUser(User u);
	void deleteUser(Long id);
	User retrieveUser(Long id);

} 
 