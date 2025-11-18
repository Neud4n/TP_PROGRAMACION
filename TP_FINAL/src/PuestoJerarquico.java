
public class PuestoJerarquico extends Puesto {
	
	private static int antiguedad_minima_requerida;
	private Empleado empleado;
	public PuestoJerarquico(String descripcion, int puestosDisponibles) {
		super(descripcion, puestosDisponibles);
		this.empleado = null;
	}

	public static void setAntiguedadMinimaRequerida(int antiguedad) {
		PuestoJerarquico.antiguedad_minima_requerida = antiguedad;
	}
	
	@Override
	public boolean sosJerarquico() {
		return true;
	}

	@Override
	public boolean tomarEmpleado(Empleado e) {
		// 
		return true;
	}

	@Override
	public void mostrarDatos() {
		// TODO Auto-generated method stub
	}
	
}
