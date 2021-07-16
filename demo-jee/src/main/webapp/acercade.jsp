<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" 	uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" 	uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- Declarar un atributo de la clase --%>
<%
response.setHeader("X-La-Mia", "una cabecera");
%>
<%!int cont = 1;%>
<%!private String toBonito(String valor) {
		if (valor == null) {
			return "Anonimo " + cont;
		} else {
			return valor.toUpperCase();
		}
	}%>

<!DOCTYPE html>
<html>
<head>
<!-- Esto es HTML y no deberia estar -->
<%@include file="WEB-INF/fragmentos/encabezados.jsp"%>
<title>Acerca de</title>
</head>
<body>
	<%@include file="WEB-INF/fragmentos/menu.jsp"%>
	<main class="container-fluid">
		<c:
		<p>
			Cont:
			<%=++cont + 1%></p>
		<h1>Acerca del curso de JEE</h1>
		<p>
			Cont:
			<%
		cont += 10;
		out.print(cont);
		%>
		</p>
		<ul>
			<%
			for (int i = 1; i <= 10; i++) {
				String nam = "Nombre " + i;
			%>
			<li>Elemento <%=nam%>
				<ol class="list-group">
					<%
					for (int j = 1; j <= 5; j++) {
					%>
					<li class="list-group-item">Hijo <%= j %></li>
					<%
					}
					%>
				</ol>
			</li>
			<%
			}
			%>
		</ul>
		<p>
			Nombre:
			<%=toBonito(request.getParameter("nom"))%></p>
		<jsp:useBean id="usr" class="com.example.presentation.servlets.Usuario" scope="session" ></jsp:useBean>
		<p>
			<jsp:getProperty property="nombre" name="usr"/>
		</p>
		<jsp:setProperty property="nombre" name="usr" value="Pepito"/>
		<p>
			<jsp:getProperty property="nombre" name="usr"/>
		</p>
	</main>
	<%@include file="WEB-INF/fragmentos/scripting.jsp"%>
</body>
</html>