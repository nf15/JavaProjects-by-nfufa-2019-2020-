package dev.fufa.services;

import java.util.List;

import dev.fufa.entities.Account;
import dev.fufa.entities.User;

/*Services: are Core functionality of logic
 * Contains all the methods we need to make app work
 * Helpful methods to actualize our application
 * Log in
 * Add Account
 * Change password 
 * Services can use multiple DAOs for their methods if we so choose
 */

public interface UserService {
 
	boolean login = false;
	Object[] getBalancesForUsers = null;  // check and keep/remove
	
	

     User createUser(String username, String password, boolean is_super_user );
	
	User loginUser(String user, String password );
	
	void logoutUser();
	public void deleteById(int id);
	public User enrollUser(User user);
	User getUserById(int id);
	void addAccountToBalance(Account account, int amount);

	void withdrawBalance(Account account, int amount);         //void mean I trust my returns 100%

	void changePassword(User user, String password);
	
	void transfertAccount(int a_id1, int a_id2);

	 List<Account> getAccountsForUser(int u_id); 
	 
	 public Account getBalanceForUser(int u_id, String type);
	 
	 void updateUser(User user);

	 void deleteAllUsers();
	  
	 void deleteNullBallance(int u_id);
	 
	 public List<User> getAllUsers() ;
	 
	 
	 

}



//Services 
//Core functionality of logic 
//Contains all the methods you need to make app work 
//Helpful methods to actualize your application
//Log in 
//Add Account 
//Change password 
//Services can use multiple DAOs for their methods if you so choose
