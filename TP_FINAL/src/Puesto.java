import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Puesto {
	private String descripcion;
	private Hashtable<Conocimiento, Integer> requerimientos;
	
	public Puesto(String descripcion, int puestosDisponibles) {
		this.requerimientos = new Hashtable<>();
	}
	
	public boolean comparoDescripcion(String descripcion) {
		return this.descripcion.equals(descripcion);
	}
	
	public abstract void mostrarDatos();
	public abstract boolean sosJerarquico();
	public abstract boolean tomarEmpleado(Empleado e);
}
