package jdbcdemo;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			// Lấy kết nối từ lớp ConnectDatabase
			Connection connection = ConnectDatabase.getConnection();

			// Khởi tạo một đối tượng HandleUser với kết nối đã thiết lập
			HandleUser handleUser = new HandleUser(connection);

			handleUser.getUsers();
//            handleUser.addUser("sitranvan", "tranvansi@gmail.com");
//            handleUser.updateUser(1, "siupdate", "si@gmail.com");
//            handleUser.deleteUser(2);
		} catch (SQLException e) {
			throw new SQLException();
		}

	}
}
