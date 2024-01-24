package intercepting;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class FiltroLogin extends HttpFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Todas las peticiones pasan por aquí
		//el filtro se ejecuta en cada llamada. Si intentamos colarnos en cualquier página
		//sin estar autenticado, le mandamos a la página de login
		
		//recogemos variable de sesion de usuario creada en LoginController
		HttpSession sesion=((HttpServletRequest)request).getSession();
		String usuario= (String) sesion.getAttribute("usuario");
		//si el usuario está autenticado (existe el atributo de sesión usuario) le dejamos pasar
		if(usuario!=null) {
			// pasa la petición a su destino
			chain.doFilter(request, response);
			return;
		}else {			
			//si la llamada es para autenticar (para logarse), le dejamos pasar a loginController
			//obtenemos la dirección de entrada y el valor del parámetro operación: FrontController?operation=doLogin
			
			//casting obtener ruta (aunque ahora no la usamos en el if
			String path = ((HttpServletRequest)request).getServletPath();
			//optener parámetro operación
			String param =  ((HttpServletRequest)request).getParameter("operation");
			
			//Si el parámetro es operation y es distinto de null. 
			//Modo cortocircuito, si es null no comprueba el parametro (esto es así por seguridad)
			if(param !=null && (param.equals("doLogin") || param.equals("doAltaCliente")  || param.equals("toAltaCliente"))) {
				// pasa la petición a su destino
				chain.doFilter(request, response);
				return;
			}else {
			//si no, le mandamos a la página de login
			request.getRequestDispatcher("inicio.html").forward(request, response);	
			}
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

} 






/*
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

public class FiltroLogin extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession sesion = ((HttpServletRequest) request).getSession();
		String usuario = (String) sesion.getAttribute("usuario");
		String param = ((HttpServletRequest) request).getParameter("operation");

		if (param != null &&  (param.equals("doLogin") || param.equals("toRegistrar") param.equals("doAltaCliente")  || param.equals("toAltaCliente")) {
			System.out.println("Llega al FiltroController");

			request.getRequestDispatcher("registrar.html").forward(request, response);
			return;
		}

		if (usuario != null) {
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
*/