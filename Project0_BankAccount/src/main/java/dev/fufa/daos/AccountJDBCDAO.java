package dev.fufa.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;      
import java.util.Set;

import dev.fufa.entities.Account;
import dev.fufa.entities.User;
import dev.fufa.utils.ConnectionUtil;

public class AccountJDBCDAO implements AccountDAO{
	
	// JDBC API provides support to execute Stored Procedures through CallableStatement interface.
	// JDBC Implements DAO

	public int createAccount(Account account) {
		
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO account VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
			ps.setInt(1, 0);
			ps.setString(2, account.getType());
			ps.setInt(3, account.getBalance());
			ps.setInt(4, account.getUserid());
			
			ps.execute();              //Ps (PreparedStatment)in Java is one of several ways to execute SQL queries using JDBC API
			                           //It is used for executing parametric query
		                               // rs = result set holds all the information we get back from the database in JDBC
			                           //CallableStatement is used for executing Stored Procedures	
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();                                  //rs.next() = moves the cursor to the first element in the result set
			
			int generatedid = rs.getInt("u_id");
			
			return generatedid;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return 0;
	}

	public Account getAccountById(int id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM account WHERE a_id = ?";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				return new Account(
				rs.getInt("a_id"),
				rs.getString("a_type"),
				rs.getInt("balance"),
				rs.getInt("u_id")
						);
							
			}

			
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		
		return null;
	}

	public List<Account> getAccountsForUser(int u_id){	
	Connection conn = ConnectionUtil.getConnection();
	String sql = "SELECT * FROM account WHERE u_id = ?";
	List<Account> accounts = new ArrayList<Account>();
	
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u_id);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			accounts.add(new Account(
			rs.getInt("a_id"),
			rs.getString("a_type"),
			rs.getInt("balance"),
			rs.getInt("u_id")
					));
						
		}
		return accounts;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return null;
}


	public Account updateAccount(Account account) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE account SET  a_type =  ?, balance = ?, u_id = ? WHERE a_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account.getType());
			ps.setInt(2, account.getBalance());
			ps.setInt(3, account.getUserid());
			ps.setInt(4, account.getId());
			
			ps.execute();
	
			return account;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return null;
	}

	public boolean deleteAccount(int a_id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "DELETE FROM account WHERE a_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, a_id);
			
			ps.execute();
	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		return false;
	}

	@Override
	public Account getBalanceForUser(int u_id, String type) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM account WHERE u_id = ? and type = ?";
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u_id);
			ps.setString(2, type);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				return new Account(
				rs.getInt("a_id"),
				rs.getString("a_type"),
				rs.getInt("balance"),
				rs.getInt("u_id")
						);
							
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

}

