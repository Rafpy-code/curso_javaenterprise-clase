package servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import exceptions.SaldoNegativoException;
import model.Movimiento;
import service.CuentaBancariaMovimientos;
import service.TipoMovimiento;

public class CajeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		CuentaBancariaMovimientos cuenta = new CuentaBancariaMovimientos(0, 0);
		List<Movimiento> movimientos = new ArrayList<>();

		if (session.getAttribute("movimientos") != null) {
			movimientos = (List<Movimiento>) session.getAttribute("movimientos");
			cuenta = (CuentaBancariaMovimientos) session.getAttribute("cuenta");
		}

		int opcion = Integer.parseInt(request.getParameter("opcion"));
		double saldoInicial = 0;
		double limiteExtraccion = 0;

		try {
			switch (opcion) {
			case 1:
				saldoInicial = Double.parseDouble(request.getParameter("saldoInicial").trim());
				limiteExtraccion = Double.parseDouble(request.getParameter("limiteExtraccion").trim());
				session.setAttribute("limiteExtraccion", limiteExtraccion);
				cuenta.setSaldo(saldoInicial);
				cuenta.setLimite(limiteExtraccion);
				session.setAttribute("cuenta", cuenta);
				movimientos.add(new Movimiento(cuenta.getSaldo(), LocalDateTime.now(), TipoMovimiento.INGRESO));
				session.setAttribute("movimientos", movimientos);
				request.getRequestDispatcher("cajero.jsp").forward(request, response);
				break;
			case 2:
				double ingresar = Double.parseDouble(request.getParameter("ingresar").trim());
				cuenta.ingresar(ingresar);
				movimientos.add(new Movimiento(ingresar, LocalDateTime.now(), TipoMovimiento.INGRESO));
				session.setAttribute("movimientos", movimientos);
				request.getRequestDispatcher("cajero.jsp").forward(request, response);
				break;
			case 3:
				double extraer = Double.parseDouble(request.getParameter("extraer").trim());
				limiteExtraccion = (Double) session.getAttribute("limiteExtraccion");

				if (cuenta.getSaldo() < limiteExtraccion) {
					System.out.println("SALDO INSUFICIENTE...");
					request.getRequestDispatcher("cajero.jsp").forward(request, response);
				}else {
					if (extraer > limiteExtraccion) {
						cuenta.extraer(limiteExtraccion);
						movimientos.add(new Movimiento(limiteExtraccion, LocalDateTime.now(), TipoMovimiento.EXTRACCION));
					} else {
						cuenta.extraer(extraer);
						movimientos.add(new Movimiento(extraer, LocalDateTime.now(), TipoMovimiento.EXTRACCION));
					}
				}
				session.setAttribute("movimientos", movimientos);
				request.getRequestDispatcher("cajero.jsp").forward(request, response);
				break;
			}
		} catch (InputMismatchException |

				SaldoNegativoException ex) {
			System.out.println("No hay suficiente saldo disponible");
		}

	}

}
