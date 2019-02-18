<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>Lesson-18</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>



	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">Spring MVC -Logos</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All books</a></li>
				<li><a href="new">new Book</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">

		<c:choose>
			<c:when test="${mode == 'BOOK_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td>${book.id}</td>
								<td>${book.name}</td>
								<td>${book.author}</td>
								<td><a href="update?id= ${book.id}">edit</a></td>
								<td><a href="delete?id= ${book.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'BOOK_EDIT' || mode == 'BOOK_CREATE'}">
				<form action="save" method="POST">
				
				<input type="hidden" value="${book.id}" class="form-control" id="id" name="id">
				
					<div class="form-group">
						<label for="bookName">Book Name:</label> <input type="text"
							class="form-control" id="name" name="name"
							value="${book.name}">
					</div>


					<div class="form-group">
						<label for="author">Author:</label> <input type="text"
							class="form-control" id="author" name="author"
							value="${book.author}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>

		</c:choose>
	</div>
</body>
</html>









