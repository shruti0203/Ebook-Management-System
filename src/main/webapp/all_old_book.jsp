<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImple"%>
<%@page import="com.entity.BookDetailes"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Old Book</title>
<style>


.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp"%>
<div class="container fluid">
<div class="row p-3">
<%
				BookDAOImple dao = new BookDAOImple(DBConnect.getconn());
				List<BookDetailes> list3 = dao.getAllOldBook();
				for (BookDetailes b : list3) {
				%>
				<div class="col-md-3">
				<div class="card crd-ho mt-3">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto() %>"
							style="width: 100px; height: 150px;" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthor() %></p>
						<p>Categories:<%=b.getBookCategory() %></p>
						<div class="row ">
							 <a href="view_books.jsp?bid=<%=b.getBookId() %>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			
	</div>
				<%
				}
				%>
				
			
		
		
		</div>
		</div>

</body>
</html>