package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.DAO.BookDAOImple;

@WebServlet("/delete")
public class BooksDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			
			BookDAOImple dao=new BookDAOImple(DBConnect.getconn());
			boolean f=dao.deleteBooks(id);
			
			HttpSession session = req.getSession();
			if (f) {

				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("admin/allbooks.jsp");
			} else {
				session.setAttribute("failMsg", "Book Delete Successfully");
				resp.sendRedirect("admin/allbooks.jsp");
			}

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
