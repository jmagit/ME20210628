<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../fragmentos/encabezados.jsp"%>
<title>Actores</title>
</head>
<body>
	<%@include file="../../fragmentos/menu.jsp"%>
	<main class="container-fluid">
		<sf:form modelAttribute="elemento" action="${pageContext.request.contextPath}/${action}">
			<sf:errors path="*" cssClass="alert alert-danger" element="div"/>
			<div class="form-group">
				<sf:label path="actorId">Código</sf:label>
				<sf:input path="actorId" cssClass="form-control" cssErrorClass="is-invalid form-control" />
				<sf:errors path="actorId" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">
				<sf:label path="firstName">Nombre</sf:label>
				<sf:input path="firstName" cssClass="form-control" 
					cssErrorClass="is-invalid form-control"/>
				<sf:errors path="firstName" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">
				<sf:label path="lastName">Apellidos</sf:label>
				<sf:input path="lastName" cssClass="form-control" 
					cssErrorClass="is-invalid form-control"/>
				<sf:errors path="lastName" cssClass="invalid-feedback" />
			</div>
			<div class="form-group">            
				<input class="btn btn-primary" type="submit" value="Enviar"/>
				<a href="${pageContext.request.contextPath}/actores" class="btn btn-primary">Volver</a>   
			</div>
		</sf:form>
	</main>
	<%@include file="../../fragmentos/scripting.jsp"%>
</body>
</html>