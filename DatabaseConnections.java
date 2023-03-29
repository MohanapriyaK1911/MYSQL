import java.sql.*;
import java.util.*;
public class DatabaseConnections {
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/mohana";
	public static String un="root";
	public static String pass="root";
	
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,un,pass);
		return con;
	}
}
