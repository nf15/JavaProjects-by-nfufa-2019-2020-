package dev.fufa.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// entities should be Java beans
// a bean is Java Class that has private fields and public getters and setters
// *technically it should serializable. Which is an deprecated interface you are not 
//  supposed to use

// Everything not a Java bean called a POJO Plain Old Java Object
public class User {

	public static final boolean Superuser = false;
	
	//user() has:  id, username, password, is superuser (=returns boolean false), and status (returns boolean)

	public static final String name = null;

	// all entities have an id
	
	private int id;
	private String username;
	private String password;
	private boolean is_super_user;
	private boolean status = false;
	private HashSet<Account> Balance = new HashSet<Account>();

	public User() { 
		super();
	}

	public User(int id, String username, String password, Boolean issuperuser, Boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_super_user = issuperuser;
		this.status = status;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Account> getBalance1() {
		return getBalance1();
	}

	public HashSet<Account> getBalance() {
		return Balance;
	}
	

	//Generate toString
	
	@Override    
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", balance=" + Balance
				+ "]";
	}

	public boolean isIs_super_user() {
		return is_super_user;
	}

	public void setIs_super_user(boolean is_super_user) {
		this.is_super_user = is_super_user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
 
	public static boolean isSuperuser() {
		return Superuser;
	}

	public static String getName() {
		return name;
	}
	
	

	
	
	           //Important

	/*
	 * All entities should have an id (some way to uniquely identify that object)
	 * Now, think, “What belongs in each entity class?” User private int id;
	 * private String username; private String password; private Set<Account>
	 * transaction/Balance = new HashSet<Account>(); Getters, setters, constructors, toString
	 */

}
