package com.techblog.dao;

import java.sql.*;

import com.techblog.entities.User;
import com.techblog.helper.ConnectionUtil;

public class UserDao {

   

    //method to insert user to data base:
    public static boolean saveUser(User user) {
        boolean f = false;
        try {
            //user -->database
            Connection con=ConnectionUtil.getconnection();
            String query = "insert into user(name,email,password,gender,about) values (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());
            
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }
    //get Element by EmailID and userpassword
    public static User getUserByEmailAndPassword(String email, String password)
    {
    	User user=null;
    	try {
            //user -->database
            Connection con=ConnectionUtil.getconnection();
            String query = "select * from user where email =? and password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
            	//fetch data from db
            	user=new User();
            	String name=rs.getString("name");
            	System.out.println(name);
            	user.setName(name);
            	int id=rs.getInt("id");
            	user.setId(id);
            	user.setEmail(rs.getString("email"));
            	 user.setPassword(rs.getString("password"));
                 user.setGender(rs.getString("gender"));
                 user.setAbout(rs.getString("about"));
                 user.setDateTime(rs.getTimestamp("radate"));
                System.out.println(rs.getString("profile"));
                 user.setProfile(rs.getString("profile"));
                 
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
        }
		return user;
    	
    }
    public static boolean updateUser(User user) {

        boolean f = false;
        try {
        	  //user -->database
            Connection con=ConnectionUtil.getconnection();
            String query = "update user set name=? , email=? , password=? , gender=? ,about=? , profile=? where  id =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, user.getName());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPassword());
            p.setString(4, user.getGender());
            p.setString(5, user.getAbout());
            p.setString(6, user.getProfile());
            p.setInt(7, user.getId());

            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
}