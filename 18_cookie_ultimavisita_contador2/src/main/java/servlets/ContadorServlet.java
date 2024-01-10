package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Cookie
		//Pedimos HttpSession y SevletContext
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();

		int actual = 0, global=0;
		
		if (session.getAttribute("contador") != null) {
			actual = (Integer) session.getAttribute("contador");
		}		
		if(context.getAttribute("global")!=null) {
			global = (Integer)context.getAttribute("global");
		}

		session.setAttribute("contador", ++actual);
		context.setAttribute("global", ++global);
		
		generarCookie(response);

		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}
	
	// Método para crear una cookie con la fecha y hora actuales y la envía al cliente
	private void generarCookie(HttpServletResponse response) {
		//LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");		
		Cookie cookie = new Cookie("fecha",LocalDateTime.now().format(formatter));		
		cookie.setMaxAge(100_000);		
		response.addCookie(cookie);
	}

}