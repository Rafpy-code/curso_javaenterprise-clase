package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import service.BuscadorService;

//@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BuscadorService buscadorService = new BuscadorService();
		String buscando = request.getParameter("tematica").toLowerCase();
		List<Resultado> encontrados = buscadorService.buscar(buscando);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<link rel='stylesheet' href='estilos.css' />");
		out.println("</head>");

		out.println("<html><body><center>");
		out.println("<h1> ***** Buscando: " + buscando + " ***** </h1>");

		for (Resultado r : encontrados) {
			out.println("<hr>");
			out.println("<h2><a href='" + r.getUrl() + "'>" + r.getUrl() + "</a></h2>");
			out.println("<h2>" + r.getTematica() + "</h2>");
			out.println("<h2>" + r.getDescripcion() + "</h2>");
			out.println("<hr>");
		}
		out.println("<br><br><a href='buscador.html'>volver</a>");
		out.println("</center></body></html>");
		out.close();
	}

}
