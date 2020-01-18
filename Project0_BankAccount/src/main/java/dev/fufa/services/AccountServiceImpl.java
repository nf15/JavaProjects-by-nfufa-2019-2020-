package dev.fufa.services;

import java.util.List;

import dev.fufa.daos.AccountDAO;
import dev.fufa.daos.AccountJDBCDAO;
import dev.fufa.entities.Account;


public class  AccountServiceImpl implements AccountService {

	AccountDAO accdao = new AccountJDBCDAO();
	
	@Override
	public Account getAccountById(int id) {
		return accdao.getAccountById(id);
	}

	@Override
	public int createAccount(Account account) {
		return accdao.createAccount(account);
	} 

	@Override
	public List<Account> getAccountsForUser(int u_id) {
		return accdao.getAccountsForUser(u_id);
	}

	@Override
	public Account updateAccount(Account account) {
		return accdao.updateAccount(account);
	}

	@Override
	public boolean deleteAccount(int a_id) {
		return accdao.deleteAccount(a_id);
	}
	
	  
	
}
