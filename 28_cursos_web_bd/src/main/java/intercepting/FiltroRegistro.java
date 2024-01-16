package intercepting;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class FiltroRegistro extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession sesion = ((HttpServletRequest) request).getSession();
		String usuario = (String) sesion.getAttribute("usuario");
		String param = ((HttpServletRequest) request).getParameter("operation");
/*
		// Para registro de usuarios NO ME DEJA PASAR DEL LOGIN
		if (param != null && param.equals("doRegistrar")) {
			request.getRequestDispatcher("registrar.html").forward(request, response);
			return;
		}
*/
		if (usuario != null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
			return;
		} else {
			// obtenemos la dirección de entrada y el valor del parámetro operation
			// String path=((HttpServletRequest)request).getServletPath();
			param = ((HttpServletRequest) request).getParameter("operation");
			if (param != null && param.equals("doLogin")) {
				chain.doFilter(request, response);
				return;
			} else {
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}
	}
}