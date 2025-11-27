import java.util.Hashtable;

public abstract class Puesto {
	private String descripcion;
	private Hashtable<Conocimiento, Integer> requerimientos;

	public Puesto(String descripcion, Hashtable<Conocimiento, Integer> requerimientos) {
		this.descripcion = descripcion;
		this.requerimientos = requerimientos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Hashtable<Conocimiento, Integer> getRequerimientos() {
		return this.requerimientos;
	}

	public boolean comparoDescripcion(String descripcion) {
		return this.descripcion.equals(descripcion);
	}

	public boolean cumpleRequisitos(Empleado e) {

		if (e.getSkills() == null) {
			System.out.println("El empleado no tiene habilidades registradas.");
			return false;
		}

		for (Conocimiento skillReq : this.requerimientos.keySet()) {
			int nivelRequerido = this.requerimientos.get(skillReq);

			if (!e.getSkills().containsKey(skillReq) || e.getSkills().get(skillReq) < nivelRequerido) {
				System.out.println("El empleado no cumple con los requisitos."); // + skillReq.getDescripcion());
				return false;
			}
		}
		return true;
	}

	public abstract void liberoPuesto(Empleado e);

	public abstract void imprimirDatos();

	public abstract boolean sosJerarquico();

	public abstract boolean tomarEmpleado(Empleado e);

	public abstract void eliminarEmpleado(int dni);
}