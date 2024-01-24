package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.implementations.ClientesServiceImpl;
import services.interfaces.ClientesServiceInterface;

import java.io.IOException;

import dtos.ClienteDto;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ClientesServiceImpl clientesServiceImpl;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDto dto=clientesServiceImpl.autenticarCliente(request.getParameter("usuario"), request.getParameter("password"));
		request.setAttribute("autenticado", dto!=null);
	}

}
