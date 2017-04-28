<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>s</title>
</head>
<body>
<%@ include file="../../layout/header.jsp"%>
	
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-8">
				<h4>List of Books</h4>

				<c:forEach items="${books}" var="book">
					<div class="row book-container-bg">
						<div class="col-lg-4 col-md-4 col-xs-12">
							<img class="card-img-left" src="../assets/images/java.jpg" width="100"
								alt="Card image cap">
						</div>

						<div class="col-lg-8 col-md-8 col-xs-12">
							<p class="card-text">${book.name}-Rs.${book.price }</p>
							<a href="../books/${book.id}" class="btn btn-success btn-sm">View</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</body>
</html>