package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

import java.io.IOException;
import java.util.List;

@WebServlet("/BuscarPorPrecioController")
public class BuscarPorPrecioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service = new CursosService();
		List<Curso> cursos = service.listarPorPrecioMax(Double.parseDouble(request.getParameter("precio")));

		request.setAttribute("cursos", cursos);
	}

}
