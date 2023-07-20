package com.admin.servlet;

import java.io.IOException;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DB.DBConnect;
import com.entity.BookDetailes;
import com.DAO.BookDAOImple;


@SuppressWarnings("serial")
@WebServlet("/add_books")
@MultipartConfig
public class BookAdd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookname=req.getParameter("bname");
			String author=req.getParameter("author");
			String price=req.getParameter("price");
			String categories=req.getParameter("categories");
			String status=req.getParameter("status");
			Part part=req.getPart("bfile");
			String fileName=part.getSubmittedFileName();
			
			BookDetailes b=new BookDetailes(bookname,author,price,categories,status,fileName,"admin");
		System.out.println(b);
			
			BookDAOImple dao=new BookDAOImple(DBConnect.getconn());
			
		
			boolean f=dao.addBooks(b);
		HttpSession session=req.getSession();
			if(f) {
				String path=getServletContext().getRealPath("")+"book";
				
				File fi=new File(path);
				part.write(path+File.separator+fileName);
			
				
				
				
				
				session.setAttribute("succMsg", "Book Add successfully");
				resp.sendRedirect("admin/add_books.jsp");
			}else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/add_books.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		}
	
