package com.vti.JDBCMavenDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Connection connection = ConnectDatabase.getConnection();
		CallProcedure callProcedure = new CallProcedure(connection);
		try {
			// Gọi procedure để update thông tin user
			// callProcedure.updateUser(1, "siupdate3", "si22@gmail.com");
			// callProcedure.insetUser("sitranvan2", "si@gmail.com");

			// Gọi procedure để xóa user
			// callProcedure.deleteUser(1);
			
			// Gọi transaction
			Transaction transaction = new Transaction(connection);
			// transaction.demoTransaction();
			transaction.deleteUsersInGroup(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
