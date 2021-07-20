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
		<table class="table">
			<tr>
				<th>Lista de Actores</th>
				<th><a class="btn btn-primary" href="${pageContext.request.contextPath}/actores/add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></th>
			</tr>
			<c:forEach var="row" items="${listado}">
				<tr>
					<td>
					<a href="${pageContext.request.contextPath}/actores/${row.actorId}">
						<c:out value="${row.firstName}" /> 
						<c:out value="${row.lastName}" />
					</a>
					</td>
					<td>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/actores/${row.actorId}/edit"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
					| <a class="btn btn-danger" href="${pageContext.request.contextPath}/actores/${row.actorId}/delete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<ul class="pagination">
		  	<c:if test = "${page.hasPrevious()}">
			    <li class="page-item">
			    	<a class="page-link" href="${pageContext.request.contextPath}/actores?page=${page.getNumber()-1}">
			    		<span aria-hidden="true">&laquo;</span>
			    	</a>
			    </li>
			</c:if>
			<c:forEach var = "i" begin = "0" end = "${page.getTotalPages() -1}">
		    	<li class="page-item<c:if test = "${i==page.getNumber()}"> active</c:if>">
		    		<a class="page-link" href="${pageContext.request.contextPath}/actores?page=${i}">${i + 1}</a>
		    	</li>
			</c:forEach>
		  	<c:if test = "${page.hasNext()}">
			    <li class="page-item">
			    	<a class="page-link" href="${pageContext.request.contextPath}/actores?page=${page.getNumber()+1}">
			    		<span aria-hidden="true">&raquo;</span>
			    	</a>
			    </li>
			</c:if>
		</ul>		
	</main>
	<%@include file="../../fragmentos/scripting.jsp"%>
</body>
</html>