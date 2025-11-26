import java.util.Hashtable;

public abstract class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private int antiguedadEnEmpresa;
	private Hashtable<Conocimiento, Integer> skills;
	private Puesto puesto;

	public Empleado(int dni, String nombre, String apellido, Hashtable<Conocimiento, Integer> skills,
			int antiguedadEnEmpresa) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.antiguedadEnEmpresa = antiguedadEnEmpresa;
		this.skills = skills;
		this.puesto = null;
	}

	public int getAntiguedad() {
		return this.antiguedadEnEmpresa;
	}

	public boolean comparoDni(int dni) {
		return this.dni == dni;
	}

	public int getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public abstract boolean sosJerarquico();

	public abstract boolean validacionAntiguedadCargo();

	public void setPuesto(Puesto p) {
		this.puesto = p;
	}

	public Hashtable<Conocimiento, Integer> getSkills() {
		return skills;
	}

	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("           FICHA DE EMPLEADO            ");
		System.out.println("========================================");
		System.out.println(String.format("DNI        : %d", this.dni));
		System.out.println(String.format("Nombre     : %s", this.nombre));
		System.out.println(String.format("Apellido   : %s", this.apellido));
		System.out.println(String.format("Antigüedad : %d años", this.antiguedadEnEmpresa));
		if (this.puesto != null) {
			System.out.println(String.format("Puesto     : %s", this.puesto.getDescripcion()));
		} else {
			System.out.println("Puesto     : (Sin asignar)");
		}
		System.out.println("----------------------------------------");
		System.out.println("Habilidades:");
		if (skills != null && !skills.isEmpty()) {
			skills.forEach((k, v) -> {
				System.out.println(String.format(" * %-20s | Experiencia: %d", k.getDescripcion(), v));
			});
		} else {
			System.out.println("  (Sin habilidades registradas)");
		}
		System.out.println("========================================");
	}
}
