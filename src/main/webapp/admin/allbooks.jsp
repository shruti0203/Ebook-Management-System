<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="com.DAO.BookDAOImple" %>
<%@page import="com.DB.DBConnect" %>
<%@page import="com.entity.BookDetailes" %>
<%@page import="java.util.List" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Books</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<c:if test="${empty userobj }">
<c:redirect url="../login.jsp"/>
</c:if>

				<c:if test="${not empty succMsg}">
				<h5 class="text-center text-success">${succMsg }</h5>
				<c:remove var="succMsg" scope="session"></c:remove>
				</c:if>
				
				<c:if test="${not empty failMsg}">
				<h5 class="text-center text-danger">${failMsg }</h5>
				<c:remove var="failMsg" scope="session"></c:remove>
				</c:if>
<h3 class="text-center">Hello Admin</h3>

<table class="table table-striped ">
  <thead class="bg-primary text-white">
    <tr>
    <th scope="col">Id</th>
      <th scope="col">Image</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Categories</th>
      <th scope="col">Status</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  BookDAOImple dao=new BookDAOImple(DBConnect.getconn());
  List<BookDetailes> list=dao.getAllBooks();
  
  for(BookDetailes b:list){
	  %>
	  <tr>
      <td><%=b.getBookId()%></td>
      <td><img src="../book/<%=b.getPhoto()%>"
       style="width:40px;height:50px;"></td>
      <td><%=b.getBookName() %></td>
      <td><%=b.getAuthor() %></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getBookCategory() %></td>
      <td><%=b.getStatus() %></td>
      <td>
      <a href="edit_books.jsp?id=<%=b.getBookId() %>" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square pr-1"></i>Edit</a>
      <a href="../delete?id=<%=b.getBookId()%>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash-can pr-1"></i>Delete</a>
      </td>
    </tr>
	  <%
	  }
  
  %>
  
 
  </tbody>
</table>
<div style="margin-top:108px;">
<%@include file="footer.jsp" %>
</div>
</body>
</html>