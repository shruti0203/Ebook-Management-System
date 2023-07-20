package com.admin.servlet;

import com.entity.BookDetailes;
import com.DAO.BookDAOImple;
import java.io.IOException;
import com.DB.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/editbooks")
public class EditBooksServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bookname = req.getParameter("bname");
			String author = req.getParameter("author");
			String price = req.getParameter("price");
			String status = req.getParameter("status");

			BookDetailes b = new BookDetailes();
			b.setBookId(id);
			b.setBookName(bookname);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);

			BookDAOImple dao = new BookDAOImple(DBConnect.getconn());
			boolean f = dao.updateEditBooks(b);

			HttpSession session = req.getSession();
			if (f) {

				session.setAttribute("succMsg", "Book Update Successfully");
				resp.sendRedirect("admin/allbooks.jsp");
			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/allbooks.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
