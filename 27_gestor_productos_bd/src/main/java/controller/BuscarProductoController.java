package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductosService;

import java.io.IOException;

@WebServlet("/BuscarProductoController")
public class BuscarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductosService productosService = new ProductosService();
		
		Producto pr = (Producto)productosService.buscarProducto(Integer.parseInt(request.getParameter("idProducto")));
		
		request.setAttribute("producto", pr);
	}

}
