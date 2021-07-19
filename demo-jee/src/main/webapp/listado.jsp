<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="WEB-INF/fragmentos/encabezados.jsp"%>
<title>Curso de JEE</title>
</head>
<body>
	<%@include file="WEB-INF/fragmentos/menu.jsp"%>
	<main class="container-fluid">
		<h1>Listado</h1>
		<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/sakila" user="root" password="root" />
		<sql:query var="actores" dataSource="${dataSource}">SELECT * FROM actor ORDER BY first_name, last_name</sql:query>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th with="60%">Nombre</th>
					<th>Actualizado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${actores.rows}">
					<tr>
						<td><c:out value="${row.first_name}" /> <c:out
								value="${row.last_name}" /></td>
						<td><fmt:formatDate pattern="dd/MMM/yyyy" value="${row.last_update}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
	<footer>
		&copy;
		<%=java.util.Calendar.getInstance().getWeekYear()%>
	</footer>
</body>
</html>