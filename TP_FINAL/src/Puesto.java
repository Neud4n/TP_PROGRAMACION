import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Puesto {
	private String descripcion;
	private Hashtable<Conocimiento, Integer> requerimientos;

	public Puesto(String descripcion, int puestosDisponibles) {
		this.descripcion = descripcion;
		this.requerimientos = new Hashtable<>();
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public boolean comparoDescripcion(String descripcion) {
		return this.descripcion.equals(descripcion);
	}

	public abstract void mostrarDatos();

	public abstract boolean sosJerarquico();

	public abstract boolean tomarEmpleado(Empleado e);
}
