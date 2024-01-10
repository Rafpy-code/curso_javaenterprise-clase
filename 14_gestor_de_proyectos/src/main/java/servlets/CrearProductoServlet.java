package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import model.Producto;
import services.ProductoService;

import java.io.IOException;

public class CrearProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductoService service = new ProductoService();
		RequestDispatcher dispatcher;
		
		// Recojo los datos que vienen de crear_producto_form.html
		String nombre = request.getParameter("nombre");
		double precio = 0;
		try {
			precio = Double.parseDouble(request.getParameter("precio"));
		}catch (Exception e) {
			System.out.println("Formato incorrecto, use el '.' para separar los decimales!");
		}
		String categoria = request.getParameter("categoria");
		
		System.out.println(nombre+" | "+precio+" | "+categoria);
		
		// Llamo al service para agregar el producto a la lista que está en el ProductoService.java
		service.agregarProducto(nombre, precio, categoria);
		
		// Transferimos la petición indicando la página a la que se va a dirigir después de agregar el producto
		dispatcher = request.getRequestDispatcher("index.html");
		
		// Pasamos al servlet destino los objeto request y response
		dispatcher.forward(request, response);
	}

}
