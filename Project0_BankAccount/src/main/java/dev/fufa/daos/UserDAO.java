package dev.fufa.daos;

import java.util.List;

import dev.fufa.entities.User;


public interface UserDAO {	

	// I applied CRUD methods : to Create, Read, Update and Delete Objects and they are in every DAOs. 
	// I have also One interface per each DAO entity

	// Create. 	
	int createUser(User user);
	   //When creating a user we will not know their initial id, 
	   // SQL automatically add as an AUTO INCREAMENT  

	// Read
	public List<User> getAllUsers();
	User getUserById(int id);
	User getUserByUsername(String username);

	// Update
	boolean updateUser(User user);

	// Delete
	boolean deleteUser(User user);
	


}

    
      // Important Notes on DAOs and CRUD methods 

//CRUD methods are in every DAO(Data Access Objects). Objects are responsible for saving information to a database.
//One interface (DAOs) per entity and I have One interface per each DAO entity
//Each DAO Only pertinent to a single object
//Responsible for creating saving objects and getting objects back
//A user DAO should only get users 
//An account DAO should only get accounts
//CRUD - create, read, update, delete
