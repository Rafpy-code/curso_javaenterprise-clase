package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;
import services.LibrosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/LibrosController")
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibrosService service = new LibrosService();
		Integer idTema = Integer.parseInt(request.getParameter("seleccionado"));
		List<Libro> libros;
		if (idTema == 0) {
			//System.out.println("libro controller get all");
			libros = service.getAllLibros();
		} else {
			//System.out.println("libro controller get por id tema");
			libros = service.getLibrosPorIdTema(idTema);
		}

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		out.println(gson.toJson(libros));
	}
}