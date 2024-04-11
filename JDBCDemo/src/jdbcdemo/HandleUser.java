package jdbcdemo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HandleUser {
	private Connection connection;

	// Constructor nhận kết nối từ bên ngoài
	public HandleUser(Connection connection) {
		this.connection = connection;
	}

	// Phương thức để lấy thông tin người dùng từ cơ sở dữ liệu
	public void getUsers() {
		try {
			String sql = "SELECT id, username, email FROM users";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("id"));
				System.out.println("Username: " + resultSet.getString("username"));
				System.out.println("Email: " + resultSet.getString("email"));
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức để thêm một người dùng mới vào cơ sở dữ liệu
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

	// Phương thức để cập nhật thông tin của một người dùng
	public void updateUser(int userId, String newUsername, String newEmail) {
		try {
			String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newUsername);
			statement.setString(2, newEmail);
			statement.setInt(3, userId);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Thông tin người dùng đã được cập nhật.");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức để xóa một người dùng từ cơ sở dữ liệu
	public void deleteUser(int userId) {
		try {
			String sql = "DELETE FROM users WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Người dùng đã được xóa khỏi cơ sở dữ liệu.");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
