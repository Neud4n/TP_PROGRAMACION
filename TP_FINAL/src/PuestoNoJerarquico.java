import java.util.ArrayList;
import java.util.Hashtable;

public class PuestoNoJerarquico extends Puesto {

	private ArrayList<EmpleadoNoJerarquico> empleados;

	public PuestoNoJerarquico(String descripcion, Hashtable<Conocimiento, Integer> requerimientos) {
		super(descripcion, requerimientos);
		this.empleados = new ArrayList<>();
	}

	@Override
	public boolean sosJerarquico() {
		return false;
	}

	@Override
	public boolean tomarEmpleado(Empleado e) {
		// Completar
		return true;
	}

	@Override
	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("           FICHA DE PUESTO              ");
		System.out.println("========================================");
		System.out.println(String.format("Puesto     : %s", this.getDescripcion()));
		System.out.println(String.format("Tipo       : %s", "No Jerárquico"));

		System.out.println("----------------------------------------");
		System.out.println("Empleados asignados:");
		if (empleados != null && !empleados.isEmpty()) {
			for (EmpleadoNoJerarquico e : empleados) {
				System.out.println(String.format(" * %s %s (DNI: %d)", e.getNombre(), e.getApellido(), e.getDni()));
			}
		} else {
			System.out.println("  (Sin empleados asignados)");
		}
		System.out.println("========================================");
	}
}
