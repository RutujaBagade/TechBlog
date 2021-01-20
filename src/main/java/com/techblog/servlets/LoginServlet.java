package com.techblog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techblog.dao.UserDao;
import com.techblog.entities.Message;
import com.techblog.entities.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
		 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
			 response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
		        try {
		        
		            
		            String email=request.getParameter("email");
		            System.out.println(email);
		            String password=request.getParameter("password");
		            System.out.println(password);
		            User user=UserDao.getUserByEmailAndPassword(email, password);
		            if(user==null)
		            {
		            	 //out.println("Invalid Details..try again");
		            	Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
		            	 HttpSession s = request.getSession();
		                 s.setAttribute("msg", msg);
		                 response.sendRedirect("login_page.jsp");
		            }
		            else
		            {
		            	
		            	out.println("You are successfully login");
		            	HttpSession session = request.getSession();
		                session.setAttribute("currentUser", user);
		                response.sendRedirect("profile_page.jsp");
		            }
}
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        	}
		    	        }
	    }