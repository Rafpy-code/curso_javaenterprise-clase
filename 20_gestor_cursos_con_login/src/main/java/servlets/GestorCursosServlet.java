package servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Curso;
import service.CursosService;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

public class GestorCursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		CursosService cursosService = new CursosService();
		
		int opcion = Integer.parseInt(request.getParameter("opcion"));

		List<Curso> cursos= new ArrayList<>();
		
		String nombre = null;
		int duracion = 0;
		double precio = 0;

		switch (opcion) {
		case 1:			
			if(session.getAttribute("listaCursos")!=null) {
				cursos = (List<Curso>)session.getAttribute("listaCursos");
			}
			nombre = request.getParameter("nombre");
			duracion = Integer.parseInt(request.getParameter("duracion"));
			precio = Double.parseDouble(request.getParameter("precio"));
			cursosService.nuevoCurso(nombre, duracion, precio);
			System.out.println("Creado -> " + nombre + "-" + duracion + "-" + precio);
			cursos.add(new Curso(nombre, duracion, precio));
			session.setAttribute("listaCursos", cursos);
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 2:
			nombre = request.getParameter("nombre");
			duracion = Integer.parseInt(request.getParameter("duracion"));
			cursosService.modificarDuracion(nombre, duracion);
			System.out.println("Modificado-> " + nombre + "-" + duracion);
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 3:
			request.getSession();
			List<Curso>original = (List<Curso>)session.getAttribute("listaCursos");

			precio = Double.parseDouble(request.getParameter("precio"));
			List<Curso> cursosL = cursosService.preciosCursoMax(precio);	
			System.out.println("LISTA FUNCIONA?");
			System.out.println(cursosL.isEmpty());
			for(Curso c:original) {
				System.out.println("cursos-> "+c.getNombre()+"-"+c.getDuracion()+"-"+c.getPrecio());
			}
			System.out.println("Despues del for");
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 4:
			nombre = request.getParameter("nombre");
			cursosService.eliminarCurso(nombre);
			System.out.println("Eliminado -> " + nombre);
			request.getRequestDispatcher("menu_gestor_cursos.jsp").forward(request, response);
			break;
		case 5:
			System.out.println("Adios");
		}

	}

}
