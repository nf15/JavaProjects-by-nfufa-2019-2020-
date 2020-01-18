package dev.fufa.entities;

public class Account {

	// this id is different for every single users

	private int id;

	// we need to be able to connect the Bank Account to each user
	private int userid;
	private String type;
	private int balance;

	public Account() {
		super();
	}

	public Account(int id, String type, int balance, int userid) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;   
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}  

	@Override
	public String toString() {
		return "Account [id=" + id + ", userid=" + userid + ", Type=" + type + ", balance=" + balance + "]";
	}

	public String deposit() {
		return "Account [id=" + id + ", userid=" + userid + ", Type=" + type + ", balance=" + balance + "]";
	
	}


	public <Int> String withdraw() {
		return "Account [id=" + id + ", userid=" + userid + ", Type=" + type + ", balance=" + balance + "]";
	}

}

/*
 * All entities should have an id (some way to uniquely identify that object)
 * Now, think, “What belongs in each entity class?” Student private int id;
 * private String username; private String password; private Set<Course>
 * transcript = new HashSet<Course>(); Getters, setters, constructors, toString
 */