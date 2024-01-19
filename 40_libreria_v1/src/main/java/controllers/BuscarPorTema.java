package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tema;
import services.TemasService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

public class BuscarPorTema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TemasService service = new TemasService();
		List<Tema> temas = service.listarTemas();
		
		request.setAttribute("temas", temas);
		
	}
}
	
/*	PrintWriter out= response.getWriter();
	response.setContentType("application/json");
	Gson gson = new Gson();
	out.println(gson.toJson(temas));
*/