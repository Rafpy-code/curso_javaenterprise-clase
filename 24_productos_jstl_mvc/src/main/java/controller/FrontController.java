package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");
		String urlView = "";

		switch (op) {
		case "doAlta":
			request.getRequestDispatcher("AltaController").include(request, response);
			urlView = "crear_producto_form.html";
			break;
		case "doBuscar":
			request.getRequestDispatcher("BuscarController").include(request, response);
			urlView = "carrito.jsp";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarController").include(request, response);
			urlView = "crear_producto_form.html";
			break;
		case "toNuevo":
			urlView = "crear_producto_form.html";
			break;
		case "toBuscar":
			urlView = "buscar.html";
		case "toEliminar":
			urlView = "carrito.jsp";
			break;
		case "toInicio":
			urlView = "carrito.html";
			break;
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}
}
