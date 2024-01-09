package servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class GestorCursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Curso> cursosNuevos = new ArrayList<Curso>();
		
		if(session.getAttribute("listaCursos")!=null) {
			cursosNuevos = (List<Curso>)session.getAttribute("listaCursos");
		}
		
		int opcion = Integer.parseInt(request.getParameter("opcion"));		
		
		switch (opcion) {
		case 1:	
			String nombre = request.getParameter("nombre").trim().toLowerCase();
			int duracion = Integer.parseInt(request.getParameter("duracion").trim().trim());
			double precio = Double.parseDouble(request.getParameter("precio").trim());
			cursosNuevos.add(new Curso(nombre, duracion, precio));
			session.setAttribute("listaCursos", cursosNuevos);
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 2:
			nombre = request.getParameter("nombre").trim().toLowerCase();
			duracion = Integer.parseInt(request.getParameter("duracion").trim());
			for (Curso c : cursosNuevos) {
				if (c.getNombre().equals(nombre)) {
					c.setDuracion(duracion);
					break;
				}
			}
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 3:
			precio = Double.parseDouble(request.getParameter("precio").trim());
			List<Curso> porPrecio = new ArrayList<>();
			for (Curso c : cursosNuevos) {
				if (c.getPrecio() <= precio) {
					porPrecio.add(c);
				}
			}
			session.setAttribute("porPrecio", porPrecio);
			request.getRequestDispatcher("ListaCursosPrecio.jsp").forward(request, response);
			break;
		case 4:
			nombre = request.getParameter("nombre").trim().toLowerCase();
			cursosNuevos.removeIf(c-> c.getNombre().equalsIgnoreCase(nombre));
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		}
	}

}
