<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Work Out Creator</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a  class="navbar-brand"> Work Out Creator </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Group</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/print"
					class="nav-link">Print</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Groups</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Group</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Num</th>
						<th>Name</th>
						<th>Group</th>
						<th>Setsum</th>
						<th>Sport</th>
						<th>Distance</th>
						<th>Spit</th>
					
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="group" items="${listGroup}">

						<tr>
							<td><c:out value="${group.num}" /></td>
							<td><c:out value="${group.name}" /></td>
							<td><c:out value="${group.groupnum}" /></td>
							<td><c:out value="${group.setsnum}" /></td>
							<td><c:out value="${group.sport}" /></td>
							<td><c:out value="${group.distance}" /></td>
							<td><c:out value="${group.split}" /></td>
							<td><a href="edit?num=<c:out value='${group.num}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								 <a href="delete?num=<c:out value='${group.num}' />">Delete</a>
								</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
		</div>
	</div>
</body>
</html>





