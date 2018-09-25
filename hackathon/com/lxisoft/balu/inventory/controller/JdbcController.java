package com.lxisoft.balu.inventory.controller;

import java.sql.*;

public class JdbcController{
	public void addCustomer(int id,String customerName,int amount){

		try{  
             Class.forName("com.mysql.jdbc.Driver");  
             
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");   
             
             String query ="insert into customerDetails (id, name, accountBalance) values (?,?,?)";
             
             PreparedStatement preparedStmt = con.prepareStatement(query);

             preparedStmt.setInt (1, id);
             preparedStmt.setString(2, customerName);
             preparedStmt.setInt (3, amount);

             preparedStmt.execute();

             /**
             while(rs.next())  
             
             System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */
             
             con.close();  
             
             }catch(Exception e){ System.out.println(e);}  
          }

    public String getCustomerName(int id){
        try{
    	Class.forName("com.mysql.jdbc.Driver");  
             
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
        
        Statement stmt=con.createStatement();  
        
        ResultSet rs=stmt.executeQuery("select * from customerDetails");  
        
        while(rs.next()){  
        if(rs.getInt("id") == id){
        	return rs.getString("name");
        }
    }

        
        //System.out.println(rs.getInt(id)+"  "+rs.getString(name)+"  "+rs.getString(accountBalance));  
        
        con.close(); 
    }catch(Exception e){ 
       
    	System.out.println(e);
    	return null;
    }
    return null; 
}

    public int getCustomerBalance(int id) {
    	 try{
    	Class.forName("com.mysql.jdbc.Driver");  
             
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
        
        Statement stmt=con.createStatement();  
        
        ResultSet rs=stmt.executeQuery("select * from customerDetails");  
        
        while(rs.next()){  
        if(rs.getInt(id) == id){
        	return rs.getInt("accountBalance");
        }
    }

        
        //System.out.println(rs.getInt(id)+"  "+rs.getString(name)+"  "+rs.getString(accountBalance));  
        
        con.close(); 
    }catch(Exception e){ 
    	System.out.println(e);} 
        return 0;

    } 
	}
