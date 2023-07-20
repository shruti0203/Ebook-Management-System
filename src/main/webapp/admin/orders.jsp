<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.Connection" %>
<%@page import="com.DAO.BookOrderImple" %>
<%@page import="com.DB.DBConnect" %>
<%@page import="com.entity.BookDetailes" %>
<%@page import="java.util.List" %>
<%@page import="com.entity.Book_Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Orders</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h3 class="text-center">Hello Admin</h3>

<table class="table table-striped ">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Address</th>
      <th scope="col">Phone no</th>
      <th scope="col">Book Name</th>
       <th scope="col">Author</th>
        <th scope="col">Price</th>
         <th scope="col">Payment type</th>
    </tr>
  </thead>
  <tbody>
  <%
  BookOrderImple dao=new BookOrderImple(DBConnect.getconn());
  List<Book_Order> blist=dao.getAllBook();
  for(Book_Order b:blist){
	  %>
	  <tr>
      <th scope="row"><%=b.getOrderId() %></th>
      <td><%=b.getUsername() %></td>
      <td><%=b.getEmail() %></td>
      <td><%=b.getFullAdd() %></td>
      <td><%=b.getPhno() %></td>
      <td><%=b.getBookName() %></td>
       <td><%=b.getAuthor() %></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getPaymentType() %></td>
    
     
    </tr>
  <%}
  %>
    

  </tbody>
</table>
<div style="margin-top:127.5px;">
<%@include file="footer.jsp" %>
</div>
</body>
</html>