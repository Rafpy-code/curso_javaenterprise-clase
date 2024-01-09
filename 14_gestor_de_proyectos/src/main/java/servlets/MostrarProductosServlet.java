package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import services.ProductoService;

import java.io.IOException;
import java.util.List;

public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductoService service = new ProductoService();
		RequestDispatcher dispatcher;

		String categoria = request.getParameter("categoria").toLowerCase();
		
		List<Producto> encontrados =service.mostrarCategoriaFuncional(categoria);

		// Seteamos los resultados de la lista
		request.setAttribute("encontrados", encontrados);

		// Transferimos la peticion a mostrar_productos.jsp
		dispatcher = request.getRequestDispatcher("mostrar_productos.jsp");
		dispatcher.forward(request, response);
	}
}
