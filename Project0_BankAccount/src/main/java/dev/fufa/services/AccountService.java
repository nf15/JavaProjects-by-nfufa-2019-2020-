package dev.fufa.services;

import java.util.List;

import dev.fufa.entities.Account;

public interface  AccountService {
	
	   public Account getAccountById(int id);
	
	// Create
		public int createAccount(Account account);

		// Read

		public List<Account> getAccountsForUser(int u_id);

		// update
		public Account updateAccount(Account account);

		// delete
		public boolean deleteAccount(int a_id);
	
}
