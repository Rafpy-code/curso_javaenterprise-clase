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

import dtos.LibroDto;

@WebServlet("/QuitarCarritoController")
public class QuitarCarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibrosService service = new LibrosService();
		HttpSession sesion = request.getSession();
		int posicion = Integer.parseInt(request.getParameter("posicion"));
		List <LibroDto> carrito = new ArrayList<LibroDto>();
		
		if(sesion.getAttribute("carrito")!=null) {
			carrito = (List<LibroDto>)sesion.getAttribute("carrito");
			carrito.remove(posicion);
		}
		
		sesion.setAttribute("carrito", carrito);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		out.println(gson.toJson(carrito));
	}

}
