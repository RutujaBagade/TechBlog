package com.techblog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techblog.dao.UserDao;
import com.techblog.entities.User;

@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 try {
	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	       // fetch all form data
            String check = request.getParameter("check");
            System.out.println();
            if (check != null) {
                
                //baki ka data yaha nikalna..
                String name = request.getParameter("user_name");
                //System.out.println(name);
                String email = request.getParameter("user_email");
                //System.out.println(email);
                String password = request.getParameter("user_password");
               // System.out.println(password);
                String gender = request.getParameter("gender");
                String about = request.getParameter("about");
                User user = new User(name, email, password, gender, about);
                boolean insertuser=UserDao.saveUser(user);
                if(insertuser)
                {
                	out.println("done");
                } else {
                    out.println("error");
                }
            }}  
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	       
	        	
	        	
	       
	       
}
}