import java.util.Hashtable;

public final class EmpleadoJerarquico extends Empleado {

	private static int antiguedad_minima_cambio = 4;
	private int antiguedadEnCargoActual;

	public EmpleadoJerarquico(int dni, String nombre, String apellido,
			Hashtable<Conocimiento, Integer> skills, int antiguedadEnEmpresa) {
		super(dni, nombre, apellido, skills, antiguedadEnEmpresa);
		this.antiguedadEnCargoActual = 0;
	}

	public static int getAntiguedadMinimaParaCambio() {
		return EmpleadoJerarquico.antiguedad_minima_cambio;
	}

	private void reiniciarAntiguedad() {
		this.antiguedadEnCargoActual = 0;
	}

	@Override
	public boolean sosJerarquico() {
		return true;
	}

	@Override
	public boolean validacionAntiguedadCargo() {
		return antiguedadEnCargoActual >= EmpleadoJerarquico.getAntiguedadMinimaParaCambio();
	}
}
