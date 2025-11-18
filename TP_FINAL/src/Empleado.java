import java.util.Hashtable;

public abstract class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private int antiguedadEnEmpresa;
	private Hashtable<Conocimiento, Integer> skills;
	private Puesto puesto;
	
	public Empleado(int dni, String nombre, String apellido, int antiguedad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.antiguedadEnEmpresa = antiguedad;
		this.skills = new Hashtable<>();
		this.puesto = null;
	}
	
	public boolean comparoDni(int dni) {
		return this.dni == dni;
	}
	
	public int getAntiguedadEmpresa() {
		return this.antiguedadEnEmpresa;
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
		System.out.println("Dni: " + this.dni);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellido: " + this.apellido);
		skills.forEach(
			(k,v) -> System.out.println("Skill: " + k.getDescripcion() + " Experiencia: " + v)
		);
	}
}
