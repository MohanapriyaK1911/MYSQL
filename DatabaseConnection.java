import java.sql.*;
public class DatabaseConnection {
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/mohana";
	private static String un="root";
	private static String pass="root";
	private static Connection con=null;
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con=DriverManager.getConnection(url,un,pass);
		return con;
	}
}
