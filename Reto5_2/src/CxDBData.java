
import java.sql.Connection;
import java.sql.DriverManager;

public class CxDBData {
	private static final String DB_URL = "jdbc:MySQL://localhost/testapp";
	private static final String username = "root";
	private static final String password = "1234";
	
	public Connection conectarBDMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, username, password);
			return conn;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Connection conectarBDSQLite() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:bd_estudiantes.db");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}