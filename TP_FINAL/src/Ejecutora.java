import java.util.Scanner;

public class Ejecutora {

	private Scanner input = new Scanner(System.in);
	private Empresa e = new Empresa();

	private void mostrarOpcionesEmpleado() {
		System.out.println("========================================");
		System.out.println("          GESTIÓN DE EMPLEADOS          ");
		System.out.println("========================================");
		System.out.println("   1. Alta Empleado"); // Hecho
		System.out.println("   2. Mostrar Ficha Empleado"); // Hecho
		System.out.println("   3. Mostrar Ficha Empleados"); // Hecho
		System.out.println("   4. Agregar habilidad a un empleado"); // Hecho
		System.out.println("   5. Baja habilidad de un empleado"); // Hecho
		System.out.println("   6. Baja Empleado"); // Hecho
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpcionesPuesto() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE PUESTOS           ");
		System.out.println("========================================");
		System.out.println("   1. Alta Puesto"); // pendiente
		System.out.println("   2. Mostrar Puesto"); // Hecho
		System.out.println("   3. Mostrar Puestos"); // Hecho
		System.out.println("   4. Agregar requerimiento"); // Hecho
		System.out.println("   5. Baja requerimiento"); // Hecho
		System.out.println("   6. Baja Puesto"); // Hecho
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpcionesHabilidad() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE HABILIDADES       ");
		System.out.println("========================================");
		System.out.println("   1. Alta Habilidad"); // Hecho
		System.out.println("   2. Mostrar Habilidades"); // Hecho
		System.out.println("   3. Baja Habilidad"); // Hecho
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpcionesConvocatoria() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE CONVOCATORIAS       ");
		System.out.println("========================================");
		System.out.println("   1. Alta Convocatoria"); // pendiente
		System.out.println("   2. Mostrar Convocatoria"); // Hecho
		System.out.println("   3. Mostrar Convocatorias"); // Hecho
		System.out.println("   4. Cerrar Convocatoria"); // Hecho
		System.out.println("   5. Agregar aspirante a una convocatoria"); // Hecho
		System.out.println("   6. Seleccionar aspirante de una convocatoria"); // Hecho
		System.out.println("   7. Mostrar aspirantes de una convocatoria"); // Hecho
		System.out.println("   8. Baja Convocatoria"); // Nuevo
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpciones() {
		System.out.println("\n========================================");
		System.out.println("           SISTEMA DE GESTIÓN           ");
		System.out.println("========================================");
		System.out.println("   1. Menú Empleados");
		System.out.println("   2. Menú Puestos");
		System.out.println("   3. Menú Convocatorias");
		System.out.println("   4. Menú Habilidades");
		System.out.println("   0. Salir");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void menuEmpleados() {
		int opcion = 0;
		do {
			this.mostrarOpcionesEmpleado();
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
				case 1:
					e.altaEmpleado();
					break;
				case 2:
					e.mostrarEmpleado();
					break;
				case 3:
					e.mostrarEmpleados();
					break;
				case 4:
					e.agregarConocimientoEmpleado();
					break;
				case 5:
					e.bajaSkillEmpleado();
					break;
				case 6:
					e.bajaEmpleado();
					break;
				case 0:
					System.out.println("Volviendo al menú principal...");
					break;
				default:
					System.out.println("Ingrese una opción valida");
					break;
			}
		} while (opcion != 0);
	}

	private void menuPuestos() {
		int opcion = 0;
		do {
			this.mostrarOpcionesPuesto();
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
				case 1:
					e.altaPuesto();
					break;
				case 2:
					e.mostrarPuesto();
					break;
				case 3:
					e.mostrarPuestos();
					break;
				case 4:
					e.agregarRequisitoPuesto();
					break;
				case 5:
					e.bajaRequisitoPuesto();
					break;
				case 6:
					e.bajaPuesto();
					break;
				case 0:
					System.out.println("Volviendo al menú principal...");
					break;
				default:
					System.out.println("Ingrese una opción valida");
					break;
			}
		} while (opcion != 0);
	}

	private void menuConvocatorias() {
		int opcion = 0;
		do {
			this.mostrarOpcionesConvocatoria();
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
				case 1:
					e.altaConvocatoria();
					break;
				case 2:
					e.mostrarConvocatoria();
					break;
				case 3:
					e.mostrarConvocatorias();
					break;
				case 4:
					e.cerrarConvocatoria();
					break;
				case 5:
					e.agregarAspirante();
					break;
				case 6:
					e.seleccionarAspirante();
					break;
				case 7:
					e.mostrarAspirantes();
					break;
				case 8:
					e.bajaConvocatoria();
					break;
				case 0:
					System.out.println("Volviendo al menú principal...");
					break;
				default:
					System.out.println("Ingrese una opción valida");
					break;
			}
		} while (opcion != 0);
	}

	private void menuConocimientos() {
		int opcion = 0;
		do {
			this.mostrarOpcionesHabilidad();
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
				case 1:
					e.altaConocimientos();
					break;
				case 2:
					e.mostrarConocimientos();
					break;
				case 3:
					e.bajaConocimiento();
					break;
				case 0:
					System.out.println("Volviendo al menú principal...");
					break;
				default:
					System.out.println("Ingrese una opción valida");
					break;
			}
		} while (opcion != 0);
	}

	private void menuPrincipal() {
		int opcion = 0;
		do {
			this.mostrarOpciones();
			opcion = input.nextInt();
			input.nextLine();
			switch (opcion) {
				case 1:
					this.menuEmpleados();
					break;
				case 2:
					this.menuPuestos();
					break;
				case 3:
					this.menuConvocatorias();
					break;
				case 4:
					this.menuConocimientos();
					break;
				case 0:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Ingrese una opción valida");
					break;
			}
		} while (opcion != 0);
	}

	public static void main(String[] args) {
		Ejecutora ejecutora = new Ejecutora();
		ejecutora.menuPrincipal();
		ejecutora.input.close();
	}
}