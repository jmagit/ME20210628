package com.example.presentations.controllers;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ApiExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class })
	public ModelAndView notFoundRequest(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("error", "404 NOT FOUND");
		mv.addObject("message", request.getRequestURI());
		return mv;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidDataException.class, MethodArgumentNotValidException.class })
	public ModelAndView badRequest(Exception exception) {
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("error", "400 BAD_REQUEST");
		mv.addObject("message", exception.getMessage());
		return mv;
	}
}
