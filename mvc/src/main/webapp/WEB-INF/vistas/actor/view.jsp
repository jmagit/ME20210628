<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../fragmentos/encabezados.jsp"%>
<title>Actores</title>
</head>
<body>
	<%@include file="../../fragmentos/menu.jsp"%>
	<main class="container-fluid">
	<h1>Detalles del actor</h1>
	<p>
		<b>Código:</b> ${elemento.actorId}<br>
		<b>Nombre:</b> ${elemento.firstName}<br>
		<b>Apellidos:</b> ${elemento.lastName}<br>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/actores" class="btn btn-primary">Volver</a>
	</p>
	</main>
	<%@include file="../../fragmentos/scripting.jsp"%>
</body>
</html>