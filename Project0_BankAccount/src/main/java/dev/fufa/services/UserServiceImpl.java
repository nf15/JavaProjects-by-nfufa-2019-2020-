package dev.fufa.services;

import java.util.List;

import dev.fufa.daos.AccountDAO;
import dev.fufa.daos.AccountJDBCDAO;
import dev.fufa.daos.UserDAO;
import dev.fufa.daos.UserJDBCDAO;
import dev.fufa.entities.Account;
import dev.fufa.entities.User;

/* Services: are Core functionality of logic
 * Contains all the methods we need to make app work
 * Helpful methods to actualize our application
 * Log in
 * Add Account
 * Change password 
 * Services can use multiple DAOs for their methods if we so choose
 */

public class UserServiceImpl implements UserService {

	UserDAO udao = new UserJDBCDAO();
	AccountDAO adao = new AccountJDBCDAO();
	
    public User createUser(String username, String password, boolean is_super_user ) {
        
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setIs_super_user(is_super_user);
    	user.setStatus(false);
    	udao.createUser(user);
    	
    	
    	return null;
    }

	public User loginUser(String username, String password) {

		User user = udao.getUserByUsername(username);

		// one line though

		
		if (user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public void addAccountToBalance(Account account, int amount) {
		// deposit
		
	    int amnt = account.getBalance() + amount;
	    account.setBalance(amnt);
	    adao.updateAccount(account);
		
	}

	public User enrollUser(User user) {
		this.udao.createUser(user);
		return user;
	}

	public void withdrawBalance(Account account, int amount){
		 int amnt = account.getBalance() - amount;
		 account.setBalance(amnt);
		 adao.updateAccount(account);
	}

	public void changePassword(User user, String password) {
		user.setPassword(password);
		udao.updateUser(user);
		
	}


	@Override
	public void transfertAccount( int a_id1, int a_id2) {
		
		Account a1 = adao.getAccountById(a_id1);         // a1, a2 can be any object/saving, checking, mr a, mr b....
		Account a2 =  adao.getAccountById(a_id2);
		
		a2.setBalance(a1.getBalance());
		a2.setType(a1.getType());
		
		adao.updateAccount(a2);
		
	}
	
	@Override
	public List<Account> getAccountsForUser(int u_id) {
		return adao.getAccountsForUser(u_id);
	}



	@Override
	public void logoutUser() {
		System.exit(0);
	}

	@Override
	public void updateUser(User user) {
		udao.updateUser(user);
	}

	@Override
	public void deleteAllUsers() {
		for(User user: udao.getAllUsers()) {
			udao.deleteUser(user);
		}
	}
	
	@Override
	public void deleteById(int id) {
		udao.deleteUser(udao.getUserById(id));
	}


	@Override
	public void deleteNullBallance(int u_id) {
		for(Account account: adao.getAccountsForUser(u_id)) {
			int a = account.getBalance();
			if( a == 0) {
				adao.deleteAccount(account.getId());
			}
		}
	}

	@Override
	public Account getBalanceForUser(int u_id, String type) {
		
		return adao.getBalanceForUser(u_id, type);
	}

	@Override
	public List<User> getAllUsers() {
		return udao.getAllUsers();
	}

	@Override
	public User getUserById(int id) {
		return udao.getUserById(id);
	}






}



