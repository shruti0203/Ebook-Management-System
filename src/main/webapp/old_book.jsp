<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImple"%>
<%@page import="com.DAO.CartDAOImple"%>
<%@page import="com.entity.User"%>
<%@page import="com.DAO.CartDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Cart"%>
<%@page import="com.entity.BookDetailes"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Old Book</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>



	<%@include file="all_component/navbar.jsp"%>
	
	<c:if test="${not empty succMsg}">
					<p class="text-center text-success">${succMsg}</p>
					<c:remove var="succMsg" scope="session"/>
					</c:if>
					
					<c:if test="${not empty failMsg}">
					<p class="text-center text-danger">${failMsg}</p>
					<c:remove var="failMsg" scope="session"></c:remove>
					</c:if>
	<div class="container p-5">

		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">BookName</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<%
				User u = (User) session.getAttribute("userobj");
				String email = u.getEmail();

				BookDAOImple dao = new BookDAOImple(DBConnect.getconn());
				List<BookDetailes> list = dao.getBookByOld(email, "Old");

				for (BookDetailes b : list) {
				%>
				<tr>
					<th scope="row"><%=b.getBookName() %></th>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getBookCategory() %></td>
					<td><a href="delete_old_book?em=<%=email %>&&id=<%=b.getBookId() %>" class="btn btn-sm btn-danger">Delete</a>
				</tr>

				<%
				}
				%>


			</tbody>
		</table>
	</div>

</body>
</html>