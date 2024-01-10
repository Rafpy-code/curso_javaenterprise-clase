package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.UsuariosService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosService service = new UsuariosService();
		RequestDispatcher dispatcher;

		if (service.autenticar(request.getParameter("usuario"), request.getParameter("pwd"))) {
			Ficha ficha=service.fichaUsuario(request.getParameter("usuario"));
			request.setAttribute("ficha", ficha);
			// Transferimos la petición a correcto.jsp
			dispatcher = request.getRequestDispatcher("correcto.jsp");
		} else {
			// Transferimos la petición a error.jsp
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
