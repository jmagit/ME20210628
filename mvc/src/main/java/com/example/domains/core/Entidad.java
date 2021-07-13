package com.example.domains.core;

import java.util.Set;

import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class Entidad<T> {
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator(); 

	@Transient
	public Set<ConstraintViolation<T>> getErrors() {
		return validator.validate((T)this);
	}
	
	@Transient
	public String getErrorsMessage() {
		var errores = getErrors();			 
		if(errores.size() == 0) return "";
		StringBuilder sb = new StringBuilder("Lista de errores");
		errores.forEach(err -> sb.append("\n" + err.getMessage()));
		return sb.toString();
	}
	
	@Transient
	public boolean isValid() {
		return getErrors().size() == 0;		
	}
	
	@Transient
	public boolean isInvalid() {
		return !isValid();		
	}
}
