package com.vti.JDBCMavenDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Handle {
	private Connection connection;

	// Constructor nhận kết nối từ bên ngoài
	public Handle(Connection connection) {
		this.connection = connection;
	}
	
	public void addUser(String username, String email) {
		try {
			String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, email);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Người dùng đã được thêm vào cơ sở dữ liệu.");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addGroup(String name, int authorId) {
		try {
			String sql = "INSERT INTO `groups` (name, author_id) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, authorId);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Nhóm đã được thêm vào cơ sở dữ liệu.");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addUserToGroup(int groupId, int userId) {
		try {
			String sql = "INSERT INTO user_group (group_id, user_id) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, groupId);
			statement.setInt(2, userId);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Nhóm người dùng đã được thêm vào cơ sở dữ liệu.");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
