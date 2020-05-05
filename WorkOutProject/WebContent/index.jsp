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
				<a class="navbar-brand"> Work Out Creator </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Groups</a></li>
			</ul>
			
						<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/print"
					class="nav-link">Print</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${group != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${group == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${group != null}">
            			Edit Group
            		</c:if>
						<c:if test="${group == null}">
            			Add New group
            		</c:if>
					</h2>
				</caption>

				<c:if test="${groupr != null}">
					<input type="hidden" name="num" value="<c:out value='${group.num}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text" value="<c:out value='${group.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Group: </label> <input type="text" value="<c:out value='${group.groupnum}' />" class="form-control"
						name="groupnum">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Set number: </label> <input type="text" value="<c:out value='${group.setsnum}' />" class="form-control"
						name="setsnum">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Sport: </label> <input type="text" value="<c:out value='${group.sport}' />" class="form-control"
						name="sport">
				</fieldset>

				<fieldset class="form-group">
					<label>Distance</label> <input type="text" value="<c:out value='${group.distance}' />" class="form-control"
						name="distance">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Split:  </label> <input type="text"  value="<c:out value='${group.split}' />" class="form-control"
						name="split">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>










