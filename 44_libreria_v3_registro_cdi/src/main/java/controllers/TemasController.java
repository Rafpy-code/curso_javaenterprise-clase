package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tema;
import services.interfaces.LibrosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dtos.TemaDto;

@WebServlet("/TemasController")
public class TemasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TemaDto> temas = service.getTemas();		
		request.setAttribute("temas", temas);
		
	}
}
	
/*	PrintWriter out= response.getWriter();
	response.setContentType("application/json");
	Gson gson = new Gson();
	out.println(gson.toJson(temas));
*/