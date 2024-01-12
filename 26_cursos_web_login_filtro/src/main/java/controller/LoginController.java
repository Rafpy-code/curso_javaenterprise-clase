package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuariosService service=new UsuariosService();
		boolean result=service.autenticar(request.getParameter("usuario"), request.getParameter("password"));
		//el resultado de la autenticación lo guardamos en un atributo de petición
		//para que lo pueda utilizar el FC
		request.setAttribute("autenticado",result );
		//si el usuario está autenticado, lo guardamos en un atributo de sesión
		if(result) {
			request.getSession().setAttribute("usuario", request.getParameter("usuario"));
		}
	}

}
