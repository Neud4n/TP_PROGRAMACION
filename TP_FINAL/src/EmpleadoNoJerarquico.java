
public final class EmpleadoNoJerarquico extends Empleado {

	public EmpleadoNoJerarquico(int dni, String nombre, String apellido, int antiguedad, Puesto puesto) {
		super(dni, nombre, apellido, antiguedad);
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
