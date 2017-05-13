<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>1</title>
</head>
<body>
<div class="wrapper">
		<div><%@ include file="../../layout/sidebar.jsp"%></div>
		<div class="main-panel">

			<div><%@ include file="../../layout/header.jsp"%></div>
			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-md-3">

							<form action="../orderItems/addToCart" method="post">

								<table>
									<tr>
										<td><input type="hidden" name="book_id"
											value="${book.id}" /></td>
									</tr>
									<tr>
										<td><input type="text" name="book_name" readonly
											value="${book.name}" /></td>
									</tr>
									<tr>
										<td><input type="text" name="book_price" readonly
											value="${book.price}" /></td>
									</tr>
									<tr>
										<td><input type="text" name="book_quantity" /></td>
									</tr>

									<tr>
										<td><button type="submit">add to cart</button></td>
									</tr>
								</table>


							</form>
							<a href="../orders/">View Cart</a>
						</div>
					</div>
				</div>
			</div>

		</div>
</div>

</body>
</html>