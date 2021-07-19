<%@page import="com.example.jdbc.Actor"%>
<%@ page import="com.example.jdbc.ActorRepository"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="WEB-INF/fragmentos/encabezados.jsp"%>
<title>Actores</title>
</head>
<body>
	<%@include file="WEB-INF/fragmentos/menu.jsp"%>
	<jsp:useBean id="dao" class="com.example.jdbc.ActorRepository" />
	<main class="container-fluid">

		<table class="table">
			<tr>
				<th>Lista de Actores</th>
				<th><a href="./actor-add.jsp">Añadir</a></th>
			</tr>
			<c:forEach var="row" items="${dao.getAll()}">
				<tr>
					<td><c:out value="${row.firstName}" /> <c:out
							value="${row.lastName}" /></td>
					<td><a
						href="./actor-edit.jsp?id=<c:out value="${row.actorId}" />">Editar</a>
						| <a href="./actor-delete.jsp?id=<c:out value="${row.actorId}" />">Borrar</a></td>
				</tr>
			</c:forEach>
		</table>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
</body>
</html>