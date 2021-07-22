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
	<jsp:useBean id="item" class="com.example.jdbc.Actor" scope="page" />
	<jsp:setProperty name="item" property="*" />
	<main class="container-fluid">
		<%
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (item.isNotValid()) {
		%>
		<div class="alert alert-danger" role="alert">Error en los datos</div>
		<%
			} else {
				dao.add(item);
				response.sendRedirect("./actor-list.jsp");
			}
		}
		%>
		<form method="post">
			<div class="form-group">
				<label for="firstName">Nombre:</label> 
				<input id="firstName" class="form-control" NAME="firstName" size="45"
					value='<%=item.getFirstName() == null ? "" : item.getFirstName()%>'>
			</div>
			<div class="form-group">
				<label for="lastName">Apellidos:</label> <input id="lastName" class="form-control" NAME="lastName" size="45"
					value='<%=item.getLastName() == null ? "" : item.getLastName()%>'>
			</div>
			<p>
				<input type="submit" class="btn btn-primary" value="Enviar">
				<a href="./actor-list.jsp" class="btn btn-primary">Volver</a>
			</p>
		</form>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
</body>
</html>