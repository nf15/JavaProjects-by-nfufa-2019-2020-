package dev.fufa.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.fufa.entities.User;
import dev.fufa.utils.ConnectionUtil;

public class UserJDBCDAO implements UserDAO{

	public int createUser(User user) {	
		
		Connection conn = ConnectionUtil.getConnection();
		 
		String sql = "Call add_user (?,?,?,?,?)";  //Answer to Q #17 stored procedure // see more on bankdb
		                                           
		try {        //answer to Q #12 & Q#17. Q#12: Use sequences to generate USER_ID and BANK_ACCOUNT_ID (u_id, a_id)
			    
			CallableStatement ps = conn.prepareCall(sql);                              //Statement.RETURN_GENERATED_KEYS?
			ps.setInt(1, 0);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, user.isIs_super_user());
			ps.setBoolean(5, user.isStatus());
			ps.execute();
			                  //Ps (PreparedStatment)in Java is one of several ways to execute SQL queries using JDBC API
                              //It is used for executing parametric query
                              // rs = result set holds all the information we get back from the database in JDBC
                              //CallableStatement is used for executing Stored Procedures
			
			ResultSet rs = ps.getGeneratedKeys();
			                                      //rs.next() = moves the cursor to the first element in the result set
			rs.next();
			int id = rs.getInt("u_id");
			
			return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public User getUserById(int id) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM user WHERE u_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			                                    //result set initially points before the first record
			rs.next();                          // this moves pointer to first record
			
			User user = new User();
			user.setId(rs.getInt("u_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getBoolean("status"));
			user.setIs_super_user(rs.getBoolean("is_super_user"));
			return user;
			
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
		return null;
	}

	public User getUserByUsername(String username) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM user WHERE username= ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			//result set initially points before the first record
			rs.next(); // moves pointer to first record
			
			User user = new User();
			user.setId(rs.getInt("u_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setIs_super_user(rs.getBoolean("is_super_user"));
			user.setStatus(rs.getBoolean("status"));
			return user;
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		
		return null;
	}

	public boolean updateUser(User user) {
		
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE user SET username = ?, password = ?, is_super_user = ?, status = ? WHERE u_id = ?";
		
	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.isIs_super_user());
			ps.setBoolean(4, user.isStatus());
			ps.setInt(5, user.getId());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteUser(User user) {
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "DELETE FROM user WHERE u_id = ?";
	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());		
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public List<User> getAllUsers() {
        Connection conn = ConnectionUtil.getConnection();
        List<User> userlist =  new ArrayList<User>();
		String sql = "SELECT * FROM user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			//result set initially points before the first record
			
			while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("u_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setIs_super_user(rs.getBoolean("is_super_user"));
			user.setStatus(rs.getBoolean("status"));
			
			userlist.add(user);
			}
			return userlist;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}


}
