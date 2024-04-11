package com.vti.JDBCMavenDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
	private Connection connection;

	// Constructor nhận kết nối từ bên ngoài
	public Transaction(Connection connection) {
		this.connection = connection;
	}
	
	public void demoTransaction() throws SQLException  {
		
		try {
			connection.setAutoCommit(false);
            Handle handle = new Handle(connection);
            handle.addGroup("group demo", 1);
            handle.addUser("user4", "user4@gmail.com");
            handle.addUserToGroup(2,8);
            connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("Rollback transaction");
		}
	}
	
	public void deleteUsersInGroup(int groupId) {
	    try {
	        // Bắt đầu giao dịch
	        connection.setAutoCommit(false);

	        // Xóa tất cả người dùng thuộc nhóm groupId
	        String deleteSql = "DELETE FROM user_group WHERE group_id = ?";
	        PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
	        deleteStatement.setInt(1, groupId); 

	        int rowsDeleted = deleteStatement.executeUpdate();
	        System.out.println("Số dòng đã xóa: " + rowsDeleted);

	        // Nếu không có lỗi, commit giao dịch
	        connection.commit();
	    } catch (SQLException e) {
	        // Xảy ra lỗi, rollback giao dịch
	        e.printStackTrace();
	        try {
	            connection.rollback();
	            System.out.println("Rollback transaction");
	        } catch (SQLException rollbackException) {
	            rollbackException.printStackTrace();
	        }
	    } finally {
	        // Đảm bảo rằng bạn đã đặt lại chế độ tự động commit sau khi sử dụng
	        try {
	            connection.setAutoCommit(true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
