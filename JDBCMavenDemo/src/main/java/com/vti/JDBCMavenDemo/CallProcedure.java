package com.vti.JDBCMavenDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallProcedure {
	private Connection connection;

	// Constructor nhận kết nối từ bên ngoài
	public CallProcedure(Connection connection) {
		this.connection = connection;
	}
	
	public void updateUser(int id, String username, String email) throws SQLException {
		String sql = "{CALL sp_update_user(?, ?, ?)}";
		CallableStatement callableStatement = connection.prepareCall(sql);
		
		callableStatement.setInt(1, id);
		callableStatement.setString(2, username);
		callableStatement.setString(3, email);
		 
		int rowCount = callableStatement.executeUpdate();
		System.out.println("Row Count affected = " + rowCount);
		connection.close();
		
	}

	public void deleteUser(int id) throws SQLException {
		String sql = "{CALL sp_delete_user(?)}";
		CallableStatement callableStatement = connection.prepareCall(sql);

		callableStatement.setInt(1, id);

		int rowCount = callableStatement.executeUpdate();
		System.out.println("Row Count affected = " + rowCount);
		connection.close();
	}
	
	public void insetUser(String username, String email) throws SQLException {
		String sql = "{CALL sp_insert_user(?, ?)}";
		CallableStatement callableStatement;
		callableStatement = connection.prepareCall(sql);
		callableStatement.setString(1, username);
		callableStatement.setString(2, email);
		int rowCount = callableStatement.executeUpdate();
		System.out.println("Row Count affected = " + rowCount);
		connection.close();
	}
}
