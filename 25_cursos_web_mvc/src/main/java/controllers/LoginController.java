package controllers;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsuariosService;

import java.io.IOException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosService service = new UsuariosService();

		if (service.autenticar(request.getParameter("usuario"), request.getParameter("password"))) {
			// Crear una sesión de usuario
			HttpSession session = request.getSession(true);
			// Establecer atributos de sesión
			request.setAttribute("usuario", request.getParameter("usuario"));
		}else {
			HttpSession session = request.getSession(false);
		}
	}
}
