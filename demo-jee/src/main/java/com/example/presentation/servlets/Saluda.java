package com.example.presentation.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Saluda
 */
public class Saluda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombrePorDefecto = "";

	/**
	 * Default constructor.
	 */
	public Saluda() {
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		nombrePorDefecto = config.getInitParameter("nombre");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = nombrePorDefecto;
		if (request.getCookies() != null) {
			Optional<Cookie> cookie = Arrays.asList(request.getCookies()).stream()
					.filter(c -> "ultimo-nombre".equals(c.getName())).findFirst();
			if (cookie.isPresent()) {
				nombre = cookie.get().getValue();
			}
		}
		if (request.getParameter("nom") != null) {
			nombre = request.getParameter("nom");
			response.addCookie(new Cookie("ultimo-nombre", nombre));
		}
		response.setContentType("text/html");
		response.setHeader("X-La-Mia", "una cabecera");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>JEE</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola " + nombre + "</h1>");
		out.println("<h2>" + request.getHeader("Accept-Language") + "</h2>");
		if (request.getParameter("secreto") != null) {
			out.println("<h2>" + request.getParameter("secreto") + "</h2>");
		}
		HttpSession ses = request.getSession(true);
		if (ses.getValue("usuario") != null) {
			out.println("<h2>Usuario: " + ses.getValue("usuario") + "</h2>");
		}
		out.println("<a href='/demo-jee/'>Inicio</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("fin".equals(request.getParameter("nom"))) {
			response.sendRedirect("/demo-jee/");
		}
		doGet(request, response);
	}

}
