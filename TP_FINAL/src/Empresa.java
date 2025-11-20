import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;

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
		this.conocimientos = new ArrayList<>();
		this.input = new Scanner(System.in);

		// Pre-cargar Empleados, Conocimientos, Convocatorias y Puestos.

		// Pre-carga de conocimientos
		Conocimiento gcp = new Conocimiento("GCP");
		Conocimiento terraform = new Conocimiento("Terraform");
		Conocimiento devops = new Conocimiento("DevOps");
		Conocimiento html = new Conocimiento("HTML");
		Conocimiento javascript = new Conocimiento("Javascript");
		Conocimiento css = new Conocimiento("CSS");
		Conocimiento linux = new Conocimiento("Linux");
		this.conocimientos.add(gcp);
		this.conocimientos.add(terraform);
		this.conocimientos.add(devops);
		// Pre-carga de HT
		Hashtable<Conocimiento, Integer> requerimientosCloudEngineer = new Hashtable<>();
		requerimientosCloudEngineer.put(gcp, 2);
		requerimientosCloudEngineer.put(terraform, 3);
		requerimientosCloudEngineer.put(devops, 1);
		requerimientosCloudEngineer.put(linux, 1);
		Hashtable<Conocimiento, Integer> requerimientosFrontEndDeveloper = new Hashtable<>();
		requerimientosFrontEndDeveloper.put(html, 1);
		requerimientosFrontEndDeveloper.put(javascript, 3);
		requerimientosFrontEndDeveloper.put(css, 1);
		// Pre-carga de Puestos
		Puesto cloudEngineer = new PuestoNoJerarquico("Cloud Engineer", 1);
		Puesto frontEndDeveloper = new PuestoNoJerarquico("FrontEnd Developer", 2);
		this.puestos.add(frontEndDeveloper);
		this.puestos.add(cloudEngineer);
		// Pre-carga de Empleados
		Empleado dan = new EmpleadoNoJerarquico(42, "Dan", "Zabala", 3, requerimientosCloudEngineer);
		dan.setPuesto(cloudEngineer);
		this.empleados.add(dan);
		Empleado aye = new EmpleadoNoJerarquico(43, "Ayelen", "Victorino", 1, requerimientosFrontEndDeveloper);
		aye.setPuesto(frontEndDeveloper);
		this.empleados.add(aye);
	}

	private Conocimiento getConocimiento(String descripcion) {
		for (Conocimiento c : conocimientos) {
			if (c.comparoDescripcion(descripcion)) {
				return c;
			}
		}
		return null;
	}

	private Empleado getEmpleado(int dni) {
		for (Empleado e : empleados) {
			if (e.comparoDni(dni)) {
				return e;
			}
		}
		return null;
	}

	private Puesto getPuesto(String descripcion) {
		for (Puesto p : puestos) {
			if (p.comparoDescripcion(descripcion)) {
				return p;
			}
		}
		return null;
	}

	private Convocatoria getConvocatoria(int id) {
		for (Convocatoria c : convocatorias) {
			if (c.comparoId(id)) {
				return c;
			}
		}
		return null;
	}

	private boolean salir() {
		int resp;
		do {
			System.out.println("Hay más datos? Si - 1 | No - 0");
			resp = input.nextInt();
			input.nextLine();
			if (resp != 0 && resp != 1) {
				System.out.println("Error: Ingrese un valor valido");
			}
		} while (resp != 0 && resp != 1);
		return resp == 1;
	}

	// Caso de uso 1: Dar de alta un empleado
	public void altaEmpleado() {

		if (this.conocimientos.isEmpty()) {
			System.out.println("No existen conocimientos en el sistema.");
			return;
		}

		if (this.puestos.isEmpty()) {
			System.out.println("No existen puestos en el sistema.");
			return;
		}

		Empleado e;
		int dni;
		do {
			System.out.println("Ingrese el DNI del empleado");
			dni = input.nextInt();
			e = this.getEmpleado(dni);
			if (e != null) {
				System.out.println("El DNI ingresado ya existe.");
			}
		} while (e != null);
		input.nextLine();
		System.out.println("Ingrese el nombre del empleado");
		String nombre = input.nextLine();
		System.out.println("Ingrese el apellido");
		String apellido = input.nextLine();

		Hashtable<Conocimiento, Integer> skills = new Hashtable<>();
		String des = "";
		Integer experiencia = null;
		do {
			System.out.println("Ingrese el conocimiento");
			des = input.nextLine();
			Conocimiento key = this.getConocimiento(des);
			if (!skills.containsKey(key)) {
				do {
					System.out.println("Ingrese los años de experiencia en :" + des);
					experiencia = input.nextInt();
				} while (experiencia > 0);
				skills.put(key, experiencia);
			} else {
				System.out.println("La habilidad, ya existe.");
			}
		} while (this.salir());

		int resp;
		do {
			System.out.println("Tipo de empleado: ");
			System.out.println("1.- Jerarquico");
			System.out.println("2.- No Jerarquico");
			resp = input.nextInt();
			input.nextLine();
			if (resp != 1 && resp != 2) {
				System.out.println("Error: Ingreso un número incorrecto.");
			}
		} while (resp != 1 && resp != 2);
		switch (resp) {
			case 1:

				break;
			case 2:
				break;
			default:
				break;
		}
		// Completar.
		// 1. Carga de datos (DNI, Nombre, Apellido) | Hecho.- Dan
		// 2. Carga de habilidades | Hecho.- Dan
		// 3. Preguntar: Jerarquico o NoJerarquico.
		// 4. Instanciar el Empleado
		// 5. Validar si el empleado puede tomar ese puesto con el método
		// instanciaPuesto.tomarEmpleado(Empleado)
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
		// eaaaaaaaaaaaaa
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
		int countJerarquicos = 0;
		int countNoJerarquicos = 0;
		System.out.println("=====================");
		System.out.println("Empleados Jerarquicos");
		System.out.println("=====================");
		for (Empleado e : empleados) {
			if (e.sosJerarquico()) {
				countJerarquicos++;
				e.imprimirDatos();
			}
		}

		if (countJerarquicos == 0) {
			System.out.println("No hay empleados jerarquicos.");
		}

		System.out.println("=====================");
		System.out.println("Empleados No Jerarquicos");
		System.out.println("=====================");
		for (Empleado e : empleados) {
			if (!e.sosJerarquico()) {
				countNoJerarquicos++;
				e.imprimirDatos();
			}
		}

		if (countNoJerarquicos == 0) {
			System.out.println("No hay empleados no jerarquicos.");
		}
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