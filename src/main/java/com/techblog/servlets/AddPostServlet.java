package com.techblog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.techblog.dao.PostDao;
import com.techblog.entities.Post;
import com.techblog.entities.User;
import com.techblog.helper.Helper;

@WebServlet("/AddPostServlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	
		 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
			 try {PrintWriter out = response.getWriter(); 
		            /* TODO output your page here. You may use following sample code. */

		            int cid = Integer.parseInt(request.getParameter("cid"));
		            String pTitle = request.getParameter("pTitle");
		            String pContent = request.getParameter("pContent");
		            String pCode = request.getParameter("pCode");
		            Part part = request.getPart("pic");
//		            getting currentuser id
		            HttpSession session = request.getSession();
		            User user = (User) session.getAttribute("currentUser");

//		            out.println("your post title is " + pTitle);
//		            out.println(part.getSubmittedFileName());
		            Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());
		            PostDao dao = new PostDao();
		            if (dao.savePost(p)) {

		                String path = request.getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
		                Helper.saveFile(part.getInputStream(), path);
		                out.println("done");
		            } else {
		                out.println("error");
		            }
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
}
