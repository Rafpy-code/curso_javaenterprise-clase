package controllers;

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

@WebServlet("/AgregarCarritoController")
public class AgregarCarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = new LibrosService();
		HttpSession sesion = request.getSession();
		Libro libro = service.getLibroPorIsbn(Integer.parseInt(request.getParameter("isbn")));
		List <Libro> carrito = new ArrayList<Libro>();
		if(sesion.getAttribute("carrito")!=null) {
			carrito = (List<Libro>)sesion.getAttribute("carrito");
		}
		
		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		out.println(gson.toJson(carrito));
	}

}
