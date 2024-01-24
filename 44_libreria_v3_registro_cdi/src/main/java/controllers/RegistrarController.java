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

@WebServlet("/RegistrarController")
public class RegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ClientesServiceImpl clientesServiceImpl;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int telefono =Integer.parseInt(request.getParameter("telefono"));
		
		clientesServiceImpl.altaCliente(new ClienteDto(usuario,password,email,telefono));

	}
}
