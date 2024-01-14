package controllers;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import services.ClienteService;
import services.ClienteServiceImpl;
import util.JpaUtil;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListarController
 */
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JpaUtil.getEntityManager();
		ClienteService service = new ClienteServiceImpl(em);
		
		List<Cliente> clientes = service.listar();
		request.setAttribute("clientes", clientes);
		
	}

}
