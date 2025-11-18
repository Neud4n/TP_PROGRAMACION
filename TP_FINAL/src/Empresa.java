import java.util.Scanner;
import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Puesto> puestos;
	private ArrayList<Empleado> empleados;
	private ArrayList<Convocatoria> convocatorias;
	private ArrayList<Conocimiento> conocimientos;
	private Scanner input;
	
	public Empresa() {
		this.puestos = new ArrayList<>();
		this.empleados = new ArrayList<>();
		this.convocatorias = new ArrayList<>();
		this.input = new Scanner(System.in);
		
		// Pre-cargar Empleados, Conocimientos, Convocatorias y Puestos.
		
	}
	
	// Método auxiliar: Obtiene un conocimiento a través de su descripción.
	private Conocimiento getConocimiento(String descripcion) {
		// Completar
		return null;
	}
	
	// Método auxiliar: Obtiene un conocimiento a través de su descripción.
	private Empleado getEmpleado(int dni) {
		// Completar
		return null;
	}
	
	// Método auxiliar: Obtiene un Puesto a través de su descripción.
	private Puesto getPuesto(String descripcion) {
		// Completar.
		return null;
	}
	
	// Método auxiliar: Obtiene una Convocatoria a través de su ID.
	private Convocatoria getConvocatoria(int id) {
		// Completar.
		return null;
	}
	
	// Caso de uso 1: Dar de alta un empleado
	public void altaEmpleado() {
		
		if(this.conocimientos.isEmpty()) {
			System.out.println("No existen conocimientos en el sistema.");
			return;
		}
		
		if(this.puestos.isEmpty()) {
			System.out.println("No existen puestos en el sistema.");
			return;
		}
		// Completar.
		// 1. Carga de datos (DNI, Nombre, Apellido)
		// 2. Carga de habilidades
		// 3. Preguntar: Jerarquico o NoJerarquico.
		// 4. Instanciar el Empleado
		// 5. Validar si el empleado puede tomar ese puesto con el método instanciaPuesto.tomarEmpleado(Empleado)
		// 5. Carga de puesto.
	}
	
	// Caso de uso 2: Dar de alta un puesto
	public void altaPuesto() {
		// Completar.
	}
	
	// Caso de uso 3: Crear convocatoria
	public void altaConvocatoria() {
		// Completar.
	}
	
	// Caso de uso 4: Alta de conocimientos
	public void altaConocimientos() {
		// Completar.
	}
	
	// Caso de uso 5: Agregar conocimiento empleado
	public void agregarSkillEmpleado() {
		// Completar.
	}
	
	// Caso de uso 6: Agregar requerimiento puesto
	public void agregarRequerimientoPuesto() {
		// Completar.
	}
	
	// Caso de uso 7: Mostrar puestos jerarquicos y no jerarquicos.
	public void mostrarPuestos() {
		// Completar.
	}
	
	// Caso de uso 8: Mostra convocatorias.
	public void mostrarConvocatorias() {
		// Primero mostrar abiertas, luego cerradas.
		// Completar.
	}
	
	// Caso de uso 9: Mostrar empleados
	public void mostrarEmpleados() {
		// Primero jerarquicos y después no jerarquicos.
		// Completar.
	}
	
	// Caso de uso 10: Mostrar conocimientos
	public void mostrarConocimientos() {
		// Completar
	}
	
	// Caso de uso 11: Agregar aspirante a una convocatoria
	public void agregarAspirante() {
		// Completar
	}
	
	// Caso de uso 12: Seleccionar aspirante de una convocatoria
	public void seleccionarAspirante() {
		// Completar
	}
	
	// Caso de uso 13: Mostrar aspirantes de una convocatoria
	public void mostrarAspirantes() {
		// Completar
	}
}
