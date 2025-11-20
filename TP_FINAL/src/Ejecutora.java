import java.util.Scanner;

public class Ejecutora {

	private Scanner input = new Scanner(System.in);
	private Empresa e = new Empresa();

	private void mostrarOpcionesEmpleado() {
		System.out.println("Opcion 1 - Alta Empleado");
		System.out.println("Opcion 2 - Mostrar Ficha Empleado");
		System.out.println("Opcion 3 - Mostrar Ficha Empleados");
		System.out.println("Opcion 0 - Volver al menú principal");
	}

	private void mostrarOpcionesPuesto() {
		System.out.println("Opcion 1 - Alta Puesto");
		System.out.println("Opcion 2 - Mostrar Puesto");
		System.out.println("Opcion 3 - Mostrar Puestos");
		System.out.println("Opcion 0 - Volver al menú principal");
	}

	private void mostrarOpciones() {
		System.out.println("Ingrese una opción:");
		System.out.println("Opcion 1 - Menú Empleados");
		System.out.println("Opcion 2 - Menú Puestos");
		System.out.println("Opcion 3 - Menú Convocatorias");
		System.out.println("Opcion 0 - Salir");
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