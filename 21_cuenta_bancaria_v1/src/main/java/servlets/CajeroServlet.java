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

/*
 * public class Cajero {
 * 
 * static CuentaBancariaMovimientos cuenta;
 * 
 * public static void main(String[] args) { int opcion; Scanner sc=new
 * Scanner(System.in); try {
 * System.out.println("Introduce saldo inicial de la cuenta:"); double
 * saldo=sc.nextDouble(); System.out.println("Introduce límite de extracción:");
 * double limite=sc.nextDouble(); cuenta=new CuentaBancariaMovimientos(saldo,
 * limite); do { try { mostrarMenu(); opcion=sc.nextInt(); switch(opcion) { case
 * 1: ingresar(); break; case 2: extraer(); break; case 3: saldoMovimientos();
 * break; case 4: System.out.println("Adios"); } }catch(InputMismatchException
 * ex) { System.out.println("Opcion incorrecta, o dato erroneo"); sc=new
 * Scanner(System.in); opcion=0; //forzar de nuevo el menú } }while(opcion!=4);
 * } catch(InputMismatchException ex) {
 * System.out.println("solo valores numéricos!!!"); }
 * 
 * } static void mostrarMenu() { System.out.println("1.- Ingresar");
 * System.out.println("2.- Extraer");
 * System.out.println("3.- Saldo y movimientos");
 * System.out.println("4.- Salir"); } static void ingresar() { Scanner sc=new
 * Scanner(System.in); System.out.println("Introduce cantidad:"); double
 * cantidad=sc.nextDouble(); cuenta.ingresar(cantidad); } static void extraer()
 * { Scanner sc=new Scanner(System.in);
 * System.out.println("Introduce cantidad:"); double cantidad=sc.nextDouble();
 * try { cuenta.extraer(cantidad); } catch(SaldoNegativoException ex) {
 * //System.out.println("La cuenta no puede quedarse en números rojos");
 * 
 * System.out.println(ex.getMessage()); ex.printStackTrace();
 * 
 * } } static void saldoMovimientos() {
 * System.out.println("Saldo actual: "+cuenta.getSaldo()); ArrayList<Movimiento>
 * movimientos=cuenta.obtenerMovimientos(); for(Movimiento m:movimientos) {
 * System.out.println(m.getCantidad()+"-"+m.getFechaHora()+"-"+m.getTipo()); } }
 * 
 * }
 */