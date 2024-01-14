package controllers;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ClienteService;
import services.ClienteServiceImpl;
import util.JpaUtil;

import java.io.IOException;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		String urlView = "";

		switch (op) {
		case "doListar":
			request.getRequestDispatcher("ListarController").include(request, response);
			urlView = "listar.jsp";
			break;
		case "toMenu":
			urlView = "menu.html";
			break;
		}
		request.getRequestDispatcher(urlView).forward(request, response);

	}

}
