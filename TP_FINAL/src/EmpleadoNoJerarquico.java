import java.util.Hashtable;

public final class EmpleadoNoJerarquico extends Empleado {

	public EmpleadoNoJerarquico(int dni, String nombre, String apellido, int antiguedad,
			Hashtable<Conocimiento, Integer> skills) {
		super(dni, nombre, apellido, skills, antiguedad);
	}

	@Override
	public boolean validacionAntiguedadCargo() {
		return true;
	}

	@Override
	public boolean sosJerarquico() {
		return false;
	}

	@Override
	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("           FICHA DE EMPLEADO            ");
		System.out.println("========================================");
		System.out.println(String.format("DNI        : %d", super.getDni()));
		System.out.println(String.format("Nombre     : %s", super.getNombre()));
		System.out.println(String.format("Apellido   : %s", super.getApellido()));
		System.out.println(String.format("Antigüedad : %d años", super.getAntiguedad()));
		if (super.getPuesto() != null) {
			System.out.println(String.format("Puesto     : %s", super.getPuesto().getDescripcion()));
		} else {
			System.out.println("Puesto     : (Sin asignar)");
		}
		System.out.println("----------------------------------------");
		System.out.println("Habilidades:");
		if (super.getSkills() != null && !super.getSkills().isEmpty()) {
			super.getSkills().forEach((k, v) -> {
				System.out.println(String.format(" * %-20s | Experiencia: %d", k.getDescripcion(), v));
			});
		} else {
			System.out.println("  (Sin habilidades registradas)");
		}
		System.out.println("========================================");
	}

}
