<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="WEB-INF/fragmentos/encabezados.jsp"%>
<title>Curso de JEE</title>
</head>
<body>
	<%@include file="WEB-INF/fragmentos/menu.jsp"%>
	<main class="container-fluid">
		<h1>Hola JSP</h1>
		<jsp:useBean id="usr" class="com.example.presentation.servlets.Usuario" scope="session" ></jsp:useBean>
		<p>
			<jsp:getProperty property="nombre" name="usr"/>
		</p>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
	<footer>
	&copy; <%= java.util.Calendar.getInstance().getWeekYear() %>
	</footer>
</body>
</html>