package com.example.presentations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppErrorController /*implements ErrorController*/ {
    private final static String ERROR_PATH = "/errors";
//    @Autowired
//    private ErrorAttributes errorAttributes; // Error Attributes in Application

    @RequestMapping(path = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(WebRequest request) {
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("error", "Error no interceptado");
		mv.addObject("message", "");
		return mv;
    }
//    @Override
//    public String getErrorPath() {
//        return ERROR_PATH;
//    }
}

