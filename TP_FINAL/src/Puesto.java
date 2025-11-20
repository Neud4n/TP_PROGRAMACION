import java.util.ArrayList;
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

	public boolean comparoDescripcion(String descripcion) {
		return this.descripcion.equals(descripcion);
	}

	public abstract void imprimirDatos();

	public abstract boolean sosJerarquico();

	public abstract boolean tomarEmpleado(Empleado e);
}
