package servlets;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;

import java.io.IOException;
import java.util.List;

import service.BuscadorService;

//@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BuscadorService buscadorService = new BuscadorService();
		List<Resultado> encontrados = buscadorService.buscar(request.getParameter("tematica").toLowerCase());
		//RequestDispatcher dispatcher; // Usamos directamente el request

		// Seteamos los resultados de la lista
		request.setAttribute("paginas", encontrados);

		// Transferimos la peticion a resultaedos.jsp
		request.getRequestDispatcher("resultados.jsp").forward(request, response);
	}
}
