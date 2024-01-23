package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Libro;
import services.LibrosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dtos.LibroDto;

@WebServlet("/AgregarCarritoController")
public class AgregarCarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		LibroDto libro = service.getLibroPorIsbn(Integer.parseInt(request.getParameter("isbn")));
		List <LibroDto> carrito = new ArrayList<LibroDto>();
		
		if(sesion.getAttribute("carrito")!=null) {
			carrito = (List<LibroDto>)sesion.getAttribute("carrito");
		}
		
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		out.println(gson.toJson(carrito));
	}

}
