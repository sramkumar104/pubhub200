<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>welcome></title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed">
	<div class="container-fluid">
		<div class="navbar-header">

			<a class="navbar-brand" href="../"><span
				class="glyphicon glyphicon-home">&nbsp;PubHub</span></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
			<c:if test="${log_id!=null}">
			<li class="nav-item">
			<a class="nav-link" href="../orders/myorders">My Orders</a>
			</li></c:if>
			<c:if test="${log_id!=null}">
			<c:if test="${log_user.role.id==1 }">
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admin </a>
			
			<a class="dropdown-item" href="../orders">All orders</a>
		
			</li>
			</c:if>
			</c:if>
		</ul>

			
					
		<ul class="navbar-nav mr-auto pull-right">                  
        <c:if  test="${!empty log_id}">
         <li class="nav-item"><a class="nav-link"> Welcome ${log_user.name}(${log_user.role.name})</a></li>
          <li class="nav-item">
            <a class="nav-link" href="../auth/logout">Logout</a>
          </li>
          </c:if>
          
         </ul>
      
         <c:if  test="${empty log_id}">
          <a href=# class="nav-link">welcome ${logid} </a>
             <a  href="../auth/logout" class="btn btn-success">logout</a>
         </c:if>

		</div>
	</div>
</nav>