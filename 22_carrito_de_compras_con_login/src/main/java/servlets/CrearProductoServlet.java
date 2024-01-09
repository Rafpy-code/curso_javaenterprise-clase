package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Producto> productos = new ArrayList<>();

		if (session.getAttribute("carrito") != null) {
			productos = (List<Producto>) session.getAttribute("carrito");
		}

		String nombre = request.getParameter("nombre");
		double precio = 0;
		try {
			precio = Double.parseDouble(request.getParameter("precio"));
		} catch (Exception e) {
			System.out.println("Formato incorrecto, use el '.' para separar los decimales!");
		}
		String categoria = request.getParameter("categoria");

		System.out.println(nombre + " | " + precio + " | " + categoria);

		productos.add(new Producto(nombre, precio, categoria));

		session.setAttribute("carrito", productos);

		request.getRequestDispatcher("crear_producto_form.html").forward(request, response);

	}

}