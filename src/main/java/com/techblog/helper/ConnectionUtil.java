package com.techblog.helper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil
{
	
		public static Connection getconnection()
		{
			Connection con=null;
			try
			{
				//1.load Driver
				Class.forName("com.mysql.jdbc.Driver");
                 //configure url,root,password
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","root");
				
			}
			catch(Exception e)
			{
				System.out.println("Connection failed...");
			}
			return con;
		}
	
}
	  