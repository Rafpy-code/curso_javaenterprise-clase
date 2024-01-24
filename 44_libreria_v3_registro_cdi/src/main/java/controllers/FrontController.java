package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		String urlView = "";
		switch (op) {
		case "doRegistrar":
			request.getRequestDispatcher("RegistrarController").include(request, response);
			urlView = "login.html";
			break;
		case "doLogin":
			request.getRequestDispatcher("LoginController").include(request, response);
			boolean autenticado=(Boolean)request.getAttribute("autenticado");
			if(!autenticado) {
				urlView = "login.html";
				break;
			}			
		case "doTemas":
			request.getRequestDispatcher("TemasController").include(request, response);
			urlView = "visor.jsp";
			break;
		case "doLibros":
			request.getRequestDispatcher("LibrosController").forward(request, response);
			return;
		case "doAgregarCarrito":
			request.getRequestDispatcher("AgregarCarritoController").forward(request, response);
			return;
		case "doQuitarCarrito":
			request.getRequestDispatcher("QuitarCarritoController").forward(request, response);
			return;
		case "toRegistrar":
			urlView = "registrar.html";
			break;
		case "toLogin":
			urlView = "login.html";
			break;
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}
}
