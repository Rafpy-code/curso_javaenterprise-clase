package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;

@WebServlet("/RegistrarController")
public class RegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuariosService service = new UsuariosService();
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		boolean ok = false;
		System.out.println("Llega a RegistrarController");
		
		if ((usuario != null && password != null && password1 != null)&&(!usuario.isEmpty() && !password.isEmpty() && !password1.isEmpty())) {
			service.agregarUsuario(usuario, password, password1);
			// response.sendRedirect("registro-exitoso.jsp");
			System.out.println("Registro exitoso! RegistrarController");
			ok = true;
			request.setAttribute("registrado", ok);
		}else {
			request.setAttribute("registrado", ok);			
			System.out.println("Usuario no registrado!");
		}	
	}
}
