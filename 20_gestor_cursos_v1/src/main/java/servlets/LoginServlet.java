package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsuariosService;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuariosService service = new UsuariosService();
		RequestDispatcher dispatcher;

		if (service.autenticar(request.getParameter("usuario"), request.getParameter("password"))) {
			// Crear una sesión de usuario
			HttpSession session = request.getSession(true);
			// Establecer atributos de sesión
			session.setAttribute("usuario", request.getParameter("usuario"));
			dispatcher = request.getRequestDispatcher("menu_gestor_cursos.jsp");
		} else {
			// transferimos petición de error
			dispatcher = request.getRequestDispatcher("login.jsp?usuario=error");
		}

		// Obtener el valor del checkbox
		String[] recordarValues = request.getParameterValues("recordar");
		// Verificar si el checkbox está marcado
		if (recordarValues != null && recordarValues.length > 0) {
			String recordarValue = recordarValues[0];
			crearCookie(response, request.getParameter("usuario"));
			System.out.println("El checkbox está marcado con el valor: " + recordarValue);
		}
		dispatcher.forward(request, response);
	}

	// Método para crear la Cookie.
	private void crearCookie(HttpServletResponse response, String usuario) {
		Cookie cookie = new Cookie("usuario", usuario);
		cookie.setMaxAge(10_000_000);
		response.addCookie(cookie);
	}
}
