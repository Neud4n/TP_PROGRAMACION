import java.util.ArrayList;

public class PuestoNoJerarquico extends Puesto{

	private ArrayList<Empleado> empleados;
	public PuestoNoJerarquico(String descripcion, int puestosDisponibles) {
		super(descripcion, puestosDisponibles);
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
	public void mostrarDatos() {
		// TODO Auto-generated method stub	
	}
}
