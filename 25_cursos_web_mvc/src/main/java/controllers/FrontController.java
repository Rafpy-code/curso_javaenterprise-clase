package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("operation");
		String urlView="";
		
		switch(op) {
			case "doLogin":
				if(request.getParameter("usuario") != null && !request.getParameter("usuario").isEmpty()) {
				request.getRequestDispatcher("LoginController").include(request, response);
				urlView="menu.html";
				}else {
					request.getRequestDispatcher("login.html").forward(request, response);
					urlView="";
				}
				break;			
			case "doGuardar":
				request.getRequestDispatcher("GuardarController").include(request, response);
				urlView="nuevo.html";
				break;
			case "doBuscar":		
				request.getRequestDispatcher("BuscarController").include(request, response);
				urlView="cursos.jsp";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarController").include(request, response);
				urlView="cursos.jsp";
				break;
			case "toNuevo":
				urlView="nuevo.html";
				break;
			case "toBuscar":
				urlView="buscar.html";
				break;
			case "toEliminar":
				urlView="eliminar.html";
				break;
			case "toMenu":
				urlView="menu.html";
				break;		
			case "toSalir":
				urlView="login.html";
				break;
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}

}
