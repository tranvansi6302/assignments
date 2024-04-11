package com.vti.JDBCMavenDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDatabase {
	 public static Connection getConnection() throws  IOException {
	        Properties properties = new Properties();
	        properties.load(new FileInputStream("src/main/resources/database.properties"));
	        String url = properties.getProperty("url");
	        String username = properties.getProperty("username");
	        String password = properties.getProperty("password");

	        try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    }
}
