package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ProductoService;

import java.io.IOException;

public class EliminarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoService service = new ProductoService();
		RequestDispatcher dispatcher;

		String nombre = request.getParameter("nombre").toLowerCase();

		service.eliminarProductoFuncional(nombre);

		// Transferimos la peticion a eliminar_producto.jsp
		dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}
}
