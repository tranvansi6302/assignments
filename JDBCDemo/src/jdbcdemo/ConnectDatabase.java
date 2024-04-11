package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private static final String URL = "jdbc:mysql://localhost:3307/demo_jdbc?"
			+ "autoReconnect=true&useSSL=false&characterEncoding=latin1";
	private static final String USERNAME = "tranvansi";
	private static final String PASSWORD = "tranvansi";

	// Phương thức này sẽ trả về một kết nối đến cơ sở dữ liệu
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}