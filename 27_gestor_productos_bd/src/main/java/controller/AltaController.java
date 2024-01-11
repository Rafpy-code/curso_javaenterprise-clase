package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;
import service.ProductosService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AltaController")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductosService productosService = new ProductosService();
		String nombre = request.getParameter("nombre");
		double precio = 0;
		try {
			precio = Double.parseDouble(request.getParameter("precio"));
		} catch (Exception e) {
			System.out.println("Formato incorrecto, use el '.' para separar los decimales!");
		}
		String categoria = request.getParameter("categoria");
		productosService.agregarProducto(nombre, categoria, precio);

	}

}