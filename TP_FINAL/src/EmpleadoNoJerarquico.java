import java.util.Hashtable;

public final class EmpleadoNoJerarquico extends Empleado {

	public EmpleadoNoJerarquico(int dni, String nombre, String apellido, int antiguedad,
			Hashtable<Conocimiento, Integer> skills) {
		super(dni, nombre, apellido, skills);
	}

	@Override
	public boolean validacionAntiguedadCargo() {
		return true;
	}

	@Override
	public boolean sosJerarquico() {
		return false;
	}
}
