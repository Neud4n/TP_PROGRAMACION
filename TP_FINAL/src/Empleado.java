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

	public Puesto getPuesto() {
		return this.puesto;
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

	public abstract boolean esNuevoIngreso();

	public abstract void imprimirDatos();

}
