package dev.fufa.daos;

import java.util.List;
import java.util.Set;

import dev.fufa.entities.Account;
import dev.fufa.entities.User;


public interface AccountDAO {
  
	// Create
	public int createAccount(Account account);

	// Read

	public Account getAccountById(int id) ;
	public List<Account> getAccountsForUser(int u_id);

	// update
	public Account updateAccount(Account account);

	// delete
	public boolean deleteAccount(int a_id);
	
	Account getBalanceForUser(int u_id, String type);
	
	

}



        //Important Notes on DAOs and CRUD methods 

//CRUD methods are in every DAO(Data Access Objects). Objects are responsible for saving information to a database.
//One interface (DAOs) per entity and I have One interface per each DAO entity
//Each DAO Only pertinent to a single object
//Responsible for creating saving objects and getting objects back
//A user DAO should only get users 
//An account DAO should only get accounts
//CRUD - create, read, update, delete
