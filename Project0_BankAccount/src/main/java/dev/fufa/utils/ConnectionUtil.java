package dev.fufa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// I created a utility class to get my database Connection object
	// JDBC stands for Java Database Connectivity
	// JDBC API (Application Program Interface) responsible for connecting to our databases

	//String conDetail = "jdbc:mariadb://halledb.cechyp3pt1tb.us-east-1.rds.amazonaws.com:3306/bankdb?user=dbusername&password=dbpassword";

	                 // -- mariadb://halledb.cechyp3pt1tb.us-east-1.rds.amazonaws.com:3306/   = copy this from Amazon RDS
	                 // -- bankdb     = copy this from mysql db //the database created same as your entity elements 
	                 // -- user=dbusername    password=dbpassword    remember this when creating in your database/amazon etc...
	
	private static Connection connection = null; 

	// we only have one connection object in the application ever!! 
	public static Connection getConnection() {

		if (connection == null) {
			return createConnection();
		} else {  
			return connection;
		}

	}
	
	private static Connection createConnection() {

		Properties props = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream("src/main/resources/connection.properties");
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String connectDetails = props.getProperty("connectInfo");

		try {
			Connection conn = DriverManager.getConnection(connectDetails);
			connection = conn;
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 

	}

}

        // Important Notes

    //I have one connection in my application that we will pass around
	// JDBC is not within Java by default. You have to add it to your program
	
	// we create a utility class to get our database Connection object

	// JDBC stands for Java Database Connectivity
	
	// JDBC API (Application Program Interface) responsible for connecting to our databases

	// JDBC is not within Java by default. We have to add it to our program
	// Maven is a tool that can be used to easily add necessary Java API's and libraries to our program

	// one connection in our application that we will pass around