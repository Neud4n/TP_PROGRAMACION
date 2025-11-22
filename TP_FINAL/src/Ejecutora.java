import java.util.Scanner;

public class Ejecutora {

	private Scanner input = new Scanner(System.in);
	private Empresa e = new Empresa();

	private void mostrarOpcionesEmpleado() {
		System.out.println("========================================");
		System.out.println("          GESTIÓN DE EMPLEADOS          ");
		System.out.println("========================================");
		System.out.println("   1. Alta Empleado");
		System.out.println("   2. Mostrar Ficha Empleado");
		System.out.println("   3. Mostrar Ficha Empleados");
		System.out.println("   4. Agregar habilidad a un empleado");
		System.out.println("   5. Baja Empleado");
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpcionesPuesto() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE PUESTOS           ");
		System.out.println("========================================");
		System.out.println("   1. Alta Puesto");
		System.out.println("   2. Mostrar Puesto");
		System.out.println("   3. Mostrar Puestos");
		System.out.println("   4. Baja Puesto");
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
	}

	private void mostrarOpcionesHabilidad() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE HABILIDADES       ");
		System.out.println("========================================");
		System.out.println("   1. Alta Habilidad");
		System.out.println("   2. Mostrar Habilidades");
		System.out.println("   3. Baja Habilidad");
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
					// e.mostrarEmpleado();
					break;
				case 3:
					e.mostrarEmpleados();
					break;
				case 4:
					e.agregarSkillEmpleado();
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
					break;
				case 3:
					e.mostrarPuestos();
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
					e.mostrarConvocatorias();
					break;
				case 3:
					// e.cerrarConvocatoria();
					break;
				case 4:
					e.agregarAspirante();
					break;
				case 5:
					// e.seleccionarAspirante();
					break;
				case 6:
					e.mostrarAspirantes();
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

	private void mostrarOpcionesConvocatoria() {
		System.out.println("========================================");
		System.out.println("           GESTIÓN DE CONVOCATORIAS       ");
		System.out.println("========================================");
		System.out.println("   1. Alta Convocatoria");
		System.out.println("   2. Mostrar Convocatorias");
		System.out.println("   3. Cerrar Convocatoria");
		System.out.println("   4. Agregar aspirante a una convocatoria");
		System.out.println("   5. Seleccionar aspirante de una convocatoria");
		System.out.println("   6. Mostrar aspirantes de una convocatoria");
		System.out.println("   0. Volver al menú principal");
		System.out.println("========================================");
		System.out.print("Ingrese una opción: ");
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
					// e.bajaConocimiento();
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