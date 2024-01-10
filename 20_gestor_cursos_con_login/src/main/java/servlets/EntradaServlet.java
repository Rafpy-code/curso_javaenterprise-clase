package servlets;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EntradaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String usuario = Arrays.stream(request.getCookies() != null ? request.getCookies() : new Cookie[0])
				.filter(c -> c.getName().equals("usuario")).findFirst().orElse(new Cookie("usuario", null)).getValue();

		if (usuario == null) {
			//request.setAttribute("usuarioNull", usuario);
			request.getRequestDispatcher("login.jsp?usuario=''").forward(request, response);
		} else {
			request.getRequestDispatcher("menu_gestor_cursos.jsp?usuario=" + usuario).forward(request, response);
		}
	}

}
