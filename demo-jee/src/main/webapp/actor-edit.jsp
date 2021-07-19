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
	<main class="container-fluid">
		<jsp:useBean id="dao" class="com.example.jdbc.ActorRepository" />
		<jsp:useBean id="item" class="com.example.jdbc.Actor" scope="page" />
		<jsp:setProperty name="item" property="*" />
		<%
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (item.isNotValid()) {
		%>
		<p style="color: red">Error en los datos</p>
		<%
			} else {
			dao.modify(item);
			response.sendRedirect("./actor-list.jsp");
			}
		} else if (request.getParameter("id") == null) {
		%>
		<div class="alert alert-danger" role="alert">Falta el identificador</div>
		<%
		} else {
			try {
				item = dao.getOne(Short.parseShort(request.getParameter("id"))).get();
			} catch (Exception e) {
			%>
			<div class="alert alert-danger" role="alert">Error en los datos</div>
			<%
			}
		}
		%>
		<form method="post">
			<p>
				<label>Código:</label>
				<%=item.getActorId()%>
				<input type="hidden" name="actorId" value='<%=item.getActorId()%>'>
			</p>
			<div class="form-group">
				<label for="firstName">Nombre:</label> <input id="firstName" class="form-control" NAME="firstName" size="45"
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