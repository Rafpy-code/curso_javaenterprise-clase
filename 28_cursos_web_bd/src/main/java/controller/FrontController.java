package controller;

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
		case "doLogin":
			request.getRequestDispatcher("LoginController").include(request, response);
			urlView = (Boolean) request.getAttribute("autenticado") ? "menu.html" : "error.jsp";
			break;
		case "doRegistrar":
			request.getRequestDispatcher("RegistrarController").include(request, response);
			urlView = "registrar.html";
			break;
		case "doGuardar":
			request.getRequestDispatcher("GuardarController").include(request, response);
			urlView = "nuevo.html";
			break;
		case "doModificarDuracion":
			request.getRequestDispatcher("ModificarDuracionController").include(request, response);
			urlView = "menu.html";
			break;
		case "doBuscar":
			request.getRequestDispatcher("BuscarController").include(request, response);
			urlView = "cursos.jsp";
			break;
		case "doListar":
			request.getRequestDispatcher("ListarController").include(request, response);
			urlView = "listaCursos.jsp";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarController").include(request, response);
			urlView = "menu.html";
			break;
		case "toNuevo":
			urlView = "nuevo.html";
			break;
		case "toEliminar":
			urlView = "eliminar.html";
			break;
		case "toBuscar":
			urlView = "buscar.html";
			break;
		case "toMenu":
			urlView = "menu.html";
			break;
		case "toRegistrar":
			urlView = "registrar.html";
			break;
		case "toLogin":
			urlView = "login.html";
			break;
		case "toModificarDuracion":
			urlView = "modificarDuracion.html";
			break;
		}
		request.getRequestDispatcher(urlView).forward(request, response);
	}
}
