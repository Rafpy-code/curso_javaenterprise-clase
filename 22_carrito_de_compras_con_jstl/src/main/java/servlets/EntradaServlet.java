package servlets;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = Arrays.stream(request.getCookies() != null ? request.getCookies() : new Cookie[0])
				.filter(c -> c.getName().equals("usuario")).findFirst().orElse(new Cookie("usuario", null)).getValue();

		if (usuario == null) {
			// request.setAttribute("usuarioNull", usuario);
			request.getRequestDispatcher("login.jsp?usuario=''").forward(request, response);
		} else {
			request.getRequestDispatcher("carrito.html?usuario=" + usuario).forward(request, response);
		}
	}

}