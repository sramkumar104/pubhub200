<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sign up</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../../layout/headers.jsp"%>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-6">

				
				<h5>Create a New Account</h5>
				
				<br/>
				
				<c:forEach items="${errors}" var="error">
					<font color="red"><c:out value="${error.defaultMessage}"  /></font> <br/>
				</c:forEach>
				
				<c:if test="${not empty ERROR_MESSAGE}">
					<font color="red"><c:out value="${ERROR_MESSAGE}" /></font> <br/>
				</c:if>
				
				
				<form id="addUserFrm" class="form-horizontal" role="form"
					method="POST" action="../auth/register">

					<div class="form-group">
						<label for="name">NAME:</label><input type="text"
							class="form-control" name="name" required="required" id="name" value="${regFormData.name.trim()}" />
					</div>


					<div class="form-group">
						<label for="emailId">E-MAILID:</label><input type="email"
							class="form-control" name="email" required="required" id="email"  value="${regFormData.email.trim()}"/>
					</div>
					<div class="form-group">
						<label for="password">PASSWORD:</label><input type="password"
							class="form-control" name="password" required="required"
							id="password" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success" id="addUserBtn">Create
							Account</button>
					</div>
					<hr />
					<div class="form-group">
						Already have an account? &nbsp;&nbsp; <a href="../"
							class='btn btn-primary'> SIGN IN</a>
					</div>
				</form>

			</div>
		</div>
</div>

</body>
</html>