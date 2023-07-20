<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Books</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color:#f0f1f2">
<%@include file="navbar.jsp" %>


<c:if test="${empty userobj }">
<c:redirect url="../login.jsp"/>
</c:if>

<div class="container">
	<div class="row">
		<div class="col-md-4 offset-md-4 p-3">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Add Books</h4>
				
				<c:if test="${not empty succMsg}">
				<p class="text-center text-success">${succMsg }</p>
				<c:remove var="succMsg" scope="session"></c:remove>
				</c:if>
				
				<c:if test="${not empty failMsg}">
				<p class="text-center text-danger">${failMsg }</p>
				<c:remove var="failMsg" scope="session"></c:remove>
				</c:if>
				
				
				<form action="../add_books" method="post" enctype="multipart/form-data">
				
				<div class="form-group">
					<label for="exampleTnputEmail">Book Name*</label><input 
					name="bname" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				
				<div class="form-group">
					<label for="exampleTnputEmail">Author Name*</label><input 
					name="author" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				
					<div class="form-group">
					<label for="exampleTnputPassword1">Price*</label><input 
					name="price" type="number" class="form-control"
					id="exampleInputPassword1" >
				</div>
				
				<div class="form-group">
					<label for="inputState">Book Categories*</label><select 
					id="inputState" name="categories" class="form-control" >
					<option selected>--select--</option>
					<option value="New">New Book</option>
					</select>
				</div>
				
					<div class="form-group">
					<label for="inputState">Book Status*</label><select 
					id="inputState" name="status" class="form-control" >
					<option selected>--select--</option>
					<option value="Active">Active</option>
					<option value="Inactive">Inactive</option>
					</select>
				</div>
				
				<div class="form-group">
				<label for="exampleFormControlFile1">Upload Photo</label><input 
				 type="file" name="bfile" class="form-control-file" id="exampleFormControlFile1"
				>
				
				</div>
				
				<button type="submit" class="btn btn-primary">Add</button>
				</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div style="margin-top:25px;">
<%@include file="footer.jsp" %>
</div>
</body>

</html>