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
             
             con.close();  
             
             }catch(Exception e){ System.out.println(" ");}  
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
        if(rs.getInt("id") == id){
        	return rs.getInt("accountBalance");
        }
    }

        con.close(); 
    }catch(Exception e){ 
    	System.out.println(e);} 
        return 0;

    }
    public void updateCustomerDetails(int updatedAmount,String name){
           try{  
             Class.forName("com.mysql.jdbc.Driver");  
             
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");   
             
             String query ="update customerDetails set accountBalance = ? where name = ?";
             
             PreparedStatement preparedStmt = con.prepareStatement(query);

             preparedStmt.setInt (1, updatedAmount);
             preparedStmt.setString(2, name);

             preparedStmt.execute();

             con.close();  
             
             }catch(Exception e){ System.out.println(" ");}  
    }
    public void updateTransactionDetails(String CustomerName,int transactionCost){
    	try{  
             Class.forName("com.mysql.jdbc.Driver");  
             
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");

             java.util.Date date=new java.util.Date();
            
             java.sql.Date sqlDate=new java.sql.Date(date.getTime());
             java.sql.Time sqlTime=new java.sql.Time(date.getTime());  
             
             String query ="insert into transaction (id, customer_Name, transaction_Time,cost,transaction_date) values (?,?,?,?,?)";
             
             PreparedStatement preparedStmt = con.prepareStatement(query);

             preparedStmt.setInt (1, 0);
             preparedStmt.setString(2,CustomerName);
             preparedStmt.setTime(3,sqlTime);
             preparedStmt.setInt(4,transactionCost);
             preparedStmt.setDate(5,sqlDate);


             preparedStmt.execute();

             con.close();  
             
             }catch(Exception e){ System.out.println(e);}  
    }

	}
