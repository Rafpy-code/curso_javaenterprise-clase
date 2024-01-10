package exceptions;

public class SaldoNegativoException extends Exception {
	public SaldoNegativoException() {
		super("El saldo va a quedar en negativo!!");
	}
}
