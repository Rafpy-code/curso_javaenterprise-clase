package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import service.TipoMovimiento;

public class Movimiento {
	private double cantidad;
	private LocalDateTime fechaHora;
	private TipoMovimiento tipo;

	public Movimiento(double cantidad, LocalDateTime fechaHora, TipoMovimiento tipo) {
		super();
		this.cantidad = cantidad;
		this.fechaHora = fechaHora;
		this.tipo = tipo;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
		this.tipo = tipo;
	}

}
