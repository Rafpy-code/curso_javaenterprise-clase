package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

}