package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import exceptions.SaldoNegativoException;
import model.CuentaBancariaLimite;
import model.Movimiento;

public class CuentaBancariaMovimientos extends CuentaBancariaLimite {

	private ArrayList<Movimiento> movimientos = new ArrayList<>();

	public CuentaBancariaMovimientos(double saldo, double limite) {
		super(saldo, limite);

	}

	@Override
	public void ingresar(double cantidad) {
		movimientos.add(new Movimiento(cantidad, LocalDateTime.now(), TipoMovimiento.INGRESO));
		super.ingresar(cantidad);
	}

	@Override
	public void extraer(double cantidad) throws SaldoNegativoException {
		super.extraer(cantidad);
		movimientos.add(new Movimiento(cantidad, LocalDateTime.now(), TipoMovimiento.EXTRACCION));
	}

	public ArrayList<Movimiento> obtenerMovimientos() {
		return movimientos;
	}

	// Método para formatear LocalDateTime.now() a un formato amigable
	public String formatearFechaHoraAmigable(LocalDateTime fechaHora) {
		// Definir el formato de la salida
		DateTimeFormatter formatoAmigable = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		// Formatear la fecha y hora
		return fechaHora.format(formatoAmigable);
	}

}
