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
	<%
	if (request.getParameter("id") == null) {
	%>
	<p style="color: red">Falta el identificador</p>
	<%
	} else {
		try {
			dao.delete(Short.parseShort(request.getParameter("id")));
			response.sendRedirect("./actor-list.jsp");
		} catch (Exception e) {
		%>
		<p style="color: red">Error en los datos</p>
		<%
		}
	}
	%>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
</body>
</html>