package com.lxisoft.ekart.EKart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConnection {

	public Connection getConnection()
    {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection( "jdbc:mysql://localhost:3306/ekartdb","root", "root");
		} 	
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		return null;
    }
	public Statement getStatement(Connection conn)
	{
		try
		{
			if(conn!=null)
			{
				return conn.createStatement();
			}
		}
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}

}
