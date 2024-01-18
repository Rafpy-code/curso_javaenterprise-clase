package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

@WebServlet("/BuscarPorCategoriaController")
public class BuscarPorCategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductosService productosService = new ProductosService();
		
		List<Producto> productos=productosService.buscarPorCategoria(request.getParameter("categoria"));
		//Ahora va directo al html en un json
		//request.setAttribute("productos", productos);
		
		PrintWriter out= response.getWriter();
		response.setContentType("application/json");
		Gson gson = new Gson();
		out.println(gson.toJson(productos));
	}

}
