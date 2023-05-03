package com.parth.ConnectionFactory;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.parth.EmpServlets.*;

import javax.servlet.RequestDispatcher;

import com.parth.EmpServlets.LoginServlet;

public class ConnectionFactory {
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/demo";
	

	 

	private static ConnectionFactory connectionFactory = null;

	
	public ConnectionFactory() {
		
		try {
			
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(String uname,String upassword) throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, uname, upassword);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	
}
