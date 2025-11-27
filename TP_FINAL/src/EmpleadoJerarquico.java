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

	public int getAntiguedadEnCargoActual() {
		return this.antiguedadEnCargoActual;
	}

	public void reiniciarAntiguedad() {
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

	@Override
	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("           FICHA DE EMPLEADO            ");
		System.out.println("========================================");
		System.out.println(String.format("DNI        : %d", super.getDni()));
		System.out.println(String.format("Nombre     : %s", super.getNombre()));
		System.out.println(String.format("Apellido   : %s", super.getApellido()));
		System.out.println(String.format("Antigüedad : %d años", super.getAntiguedad()));
		System.out.println(String.format("Antigüedad en cargo actual : %d años", this.antiguedadEnCargoActual));
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
