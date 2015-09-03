package db;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Db {
	public static Connection getConnection(){
		Connection  connection = null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
//			connection= (Connection) DriverManager.getConnection("jdbc:mysql://SAE_MYSQL_HOST_M:SAE_MYSQL_PORT","SAE_MYSQL_USER","SAE_MYSQL_PASS");
			connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/unicom7","root","root");
			connection.setAutoCommit(false);
		}
		catch(Exception ex){
				ex.printStackTrace();
		}
		return connection;
	}
}
