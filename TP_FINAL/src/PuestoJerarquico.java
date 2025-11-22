import java.util.Hashtable;

public class PuestoJerarquico extends Puesto {

	private static int antiguedad_minima_requerida;
	private EmpleadoJerarquico empleado;

	public PuestoJerarquico(String descripcion, Hashtable<Conocimiento, Integer> requerimientos) {
		super(descripcion, requerimientos);
		this.empleado = null;
	}

	public static void setAntiguedadMinimaRequerida(int antiguedad) {
		PuestoJerarquico.antiguedad_minima_requerida = antiguedad;
	}

	@Override
	public boolean sosJerarquico() {
		return true;
	}

	@Override
	public boolean tomarEmpleado(Empleado e) {
		if (!e.sosJerarquico()) {
			System.out.println("El empleado no es jerárquico.");
			return false;
		}
		if (this.empleado != null) {
			System.out.println("El puesto ya tiene un empleado asignado.");
			return false;
		}
		if (e.getAntiguedad() < PuestoJerarquico.antiguedad_minima_requerida) {
			System.out.println("El empleado no cumple con la antiguedad mínima requerida.");
			return false;
		}
		if (!this.cumpleRequisitos(e)) {
			return false;
		}
		if (!e.validacionAntiguedadCargo()) {
			System.out.println("El empleado no cumple con la antiguedad mínima requerida en su cargo actual.");
			return false;
		}
		this.empleado = (EmpleadoJerarquico) e;
		this.empleado.setPuesto(this);
		this.empleado.reiniciarAntiguedad();
		return true;
	}

	@Override
	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("           FICHA DE PUESTO              ");
		System.out.println("========================================");
		System.out.println(String.format("Puesto     : %s", this.getDescripcion()));
		System.out.println(String.format("Tipo       : %s", "Jerárquico"));
		System.out.println(String.format("Antigüedad Minima : %d años", PuestoJerarquico.antiguedad_minima_requerida));

		if (this.empleado != null) {
			System.out.println(String.format("Asignado a : %s %s (DNI: %d)",
					this.empleado.getNombre(), this.empleado.getApellido(), this.empleado.getDni()));
		} else {
			System.out.println("Asignado a : (Vacante)");
		}
		System.out.println("========================================");
	}

}
