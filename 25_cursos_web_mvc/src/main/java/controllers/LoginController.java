package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosService service = new UsuariosService();

		if (service.autenticar(request.getParameter("usuario"), request.getParameter("password"))) {
			request.setAttribute("usuario", request.getParameter("usuario"));
		} else {
			request.setAttribute("usuario", null);
		}
	}
}
