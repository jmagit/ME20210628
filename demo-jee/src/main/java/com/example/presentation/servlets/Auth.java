package com.example.presentation.servlets;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Auth
 */
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Auth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		if("P@$$w0rd".equals(request.getParameter("pwd")) && request.getParameter("usr") != null) {
			HttpSession ses = request.getSession(true);
			ses.putValue("usuario", request.getParameter("usr"));
			response.sendRedirect("saluda");
		}
		if(request.getParameter("logout") != null) {
			HttpSession ses = request.getSession(true);
			ses.invalidate();
			response.sendRedirect("/demo-jee/");
		}
		response.getWriter().append("No se: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
