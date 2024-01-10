package model;

import exceptions.SaldoNegativoException;

public class CuentaBancaria {
	private double saldo;

	public CuentaBancaria(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(double cantidad) {
		saldo += cantidad;
	}

	public void extraer(double cantidad) throws SaldoNegativoException {
		if (cantidad > saldo) {
			// provocamos la excepción
			throw new SaldoNegativoException();
		}
		saldo -= cantidad;
	}

}
