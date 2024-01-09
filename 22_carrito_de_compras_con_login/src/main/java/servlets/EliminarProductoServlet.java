package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;

import java.io.IOException;
import java.util.List;

public class EliminarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		List<Producto> productos = (List<Producto>)session.getAttribute("carrito");
		
		//productos.forEach(p->System.out.println(p.toString()));
		
		String nombre = request.getParameter("nombre");
		
		productos.removeIf(p->p.getNombre().equals(nombre));
		
			
		request.getRequestDispatcher("carrito.jsp").forward(request, response);	
		
	}

}
