package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

public Connection getConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	
	

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ekart","root","root");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	  
}

public Statement getStatement(Connection con){
	  
	try{
	if(con!=null){
			return con.createStatement();
		} }
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
}
