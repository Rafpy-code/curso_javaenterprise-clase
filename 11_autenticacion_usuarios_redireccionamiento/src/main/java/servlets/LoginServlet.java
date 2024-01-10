package servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosService service = new UsuariosService();

		if (service.autenticar(request.getParameter("usuario"), request.getParameter("pwd"))) {
			// Redireccionamos la petición a correcto.jsp
			response.sendRedirect("correcto.jsp?usuario=" + request.getParameter("usuario"));
		} else {
			// Redireccionamos la petición a error.jsp
			response.sendRedirect("error.jsp?usuario=" + request.getParameter("usuario") + "&password="
					+ request.getParameter("pwd"));
		}
	}
}
