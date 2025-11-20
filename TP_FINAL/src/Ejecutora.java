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
					break;
				case 3:
					e.mostrarEmpleados();
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
					break;
				case 4:
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