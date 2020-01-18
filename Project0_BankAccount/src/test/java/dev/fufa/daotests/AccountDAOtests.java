package dev.fufa.daotests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import org.junit.Test;
import dev.fufa.daos.AccountDAO;
import dev.fufa.daos.AccountJDBCDAO;
import dev.fufa.entities.Account;
import dev.fufa.entities.User;

public class AccountDAOtests {

	public static AccountDAO adao = new AccountJDBCDAO();

	
	@Test
	public void createAccount() {
		Account account = new Account(0,"Checking", 80000, 4);
		
		
		int id = adao.createAccount(account);
		System.out.println(id);
	}
	
	@Test
	public void getAccountsForUser() {
		User user = new User();
		user.setId(3);
		
		List<Account> accounts = adao.getAccountsForUser(user.getId());
		
		System.out.println(accounts);
	}

}
