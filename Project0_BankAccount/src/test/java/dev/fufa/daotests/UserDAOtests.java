package dev.fufa.daotests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import dev.fufa.daos.UserDAO;
import dev.fufa.daos.UserJDBCDAO;
//import dev.fufa.daos.UserJDBCDAO;
import dev.fufa.entities.User;
import dev.fufa.utils.ConnectionUtil; 
import junit.framework.Assert;

public class UserDAOtests {

	UserDAO udao = new UserJDBCDAO();

	// JUnit tests do not run in order and most tests should be atomic (a test cannot be broken into smaller tests)
	
	@Test
	public void createUser() {

		User user = new User(0, "username", "password", false, false);
		int id = udao.createUser(user);
		System.out.println(id);
	}

	@Test
	public void getUserById() {

		User user = udao.getUserById(1);
		Assert.assertNotNull(user);
		System.out.println(user);
	}
        
	@Test
	
	public void getUserByUsername() {
	User user = udao.getUserByUsername("djohn");
	System.out.println(user);

	}

//	@Test
//	public void updateUser() {
//		User user = new User(1, "username", "password", false);
//		udao.updateUser(user);
//
//	}
//
//	@Test
//	public void deleteUser() {
//		User user = new User(1, "Username", "password", false);
//		udao.deleteUser(user);
//
//	}
//
//	@Test
//	public void SQLinjectionL33tHakker() { // we should know but not necessary to apply here the SQL injection
//		// WHY YOU SHOULD NOT USE STATEMENT AND STRING CONCATATION TO MAKE YOUR SQL
//		// COMMANDS IN JAVA
//		String username = "'cavsfan4eva' -- ";
//		String password = "'spaghetios'";
//		String sql = "SELECT * FROM user WHERE username =" + username + " AND password = " + password;
//
//		Connection conn = ConnectionUtil.getConnection();
//
//		try {
//			Statement statement = conn.createStatement();
//
//			ResultSet rs = statement.executeQuery(sql);
//
//			// result set initially points before the first record
//			rs.next(); // moves pointer to first record
//
//			User user = new User();
//			user.setId(rs.getInt("u_id"));
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			
//
//			System.out.println(user);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

}
