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
		<sf:form modelAttribute="elemento" action="${pageContext.request.contextPath}/${action}" novalidate="true">
			<sf:errors path="*" cssClass="alert alert-danger" element="div"/>
			<div class="form-group">
				<sf:label path="actorId">Código</sf:label>
				<sf:input type="number" required="true" path="actorId" cssClass="form-control" cssErrorClass="is-invalid form-control" />
				<sf:errors path="actorId" cssClass="invalid-feedback" />
				<div id="actorIdErr" class="is-invalid"></div>
			</div>
			<div class="form-group">
				<sf:label path="firstName">Nombre</sf:label>
				<sf:input required="true" minlength="2" maxlength="45" path="firstName" cssClass="form-control" 
					cssErrorClass="is-invalid form-control"/>
				<sf:errors path="firstName" cssClass="invalid-feedback" />
				<div id="firstNameErr" class="is-invalid"></div>
			</div>
			<div class="form-group">
				<sf:label path="lastName">Apellidos</sf:label>
				<sf:input required="true" maxlength="45" path="lastName" cssClass="form-control" 
					cssErrorClass="is-invalid form-control"/>
				<sf:errors path="lastName" cssClass="invalid-feedback" />
				<div id="lastNameErr" class="is-invalid"></div>
			</div>
			<div class="form-group">            
				<input id="btnEnviar" class="btn btn-primary" type="submit" value="Enviar"/>
				<a href="${pageContext.request.contextPath}/actores" class="btn btn-primary">Volver</a>   
			</div>
		</sf:form>
	</main>
	<%@include file="../../fragmentos/scripting.jsp"%>
	<script type="text/javascript">
	document.getElementById('elemento').addEventListener('submit', function(ev) {
		let valid = true;
		let form = ev.target;
		for(let cmp in form) {
			if(cmp == undefined || isNaN(parseInt(cmp))) break;
			let value = form[cmp].value;
			let msg = '';
			switch(form[cmp].name) {
			case 'actorId':				
				if(value == '' ) {
					msg = 'Es obligatorio';
				} else if(isNaN(parseInt(value))) {
					msg = 'Debe ser númerico';
				}
				document.getElementById('actorIdErr').textContent = msg;
				if(msg !== '') valid = false;
				break;
			case 'firstName':				
				if(value == '' ) {
					msg = 'Es obligatorio';
				} else if(2 > value.length || value.length > 45) {
					msg = 'Debe tener entre 2 y 45 caracteres';
				}
				document.getElementById('firstNameErr').textContent = msg;
				if(msg !== '') valid = false;
				break;
			case 'lastName':				
				if(value == '' ) {
					msg = 'Es obligatorio';
				} else if(value.length > 45) {
					msg = 'Debe tener entre 2 y 45 caracteres';
				}
				document.getElementById('lastNameErr').textContent = msg;
				if(msg !== '') valid = false;
				break;
			}
		}
		if(!valid)
			ev.preventDefault();
	});	
	/*	
	document.getElementById('firstName').addEventListener('change', function(ev) {
		let value = ev.target.value;
		let msg = '';
		if(value == '' ) {
			msg = 'Es obligatorio';
		} else if(2 > value.length || value.length > 45) {
			msg = 'Debe tener entre 2 y 45 caracteres';
		}
		document.getElementById('firstNameErr').textContent = msg;
	});
*/
</script>
</body>
</html>