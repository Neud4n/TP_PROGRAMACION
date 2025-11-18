import java.util.Scanner;

public class Ejecutora {
	
	private Scanner input = new Scanner(System.in);
	
	private void mostrarOpciones() {
		System.out.println("Ingrese una opción:");
		System.out.println("Opcion 1 - ");
		System.out.println("Opcion 2 - ");
		System.out.println("Opcion 3 - ");
		System.out.println("Opcion 4 - ");
		System.out.println("Opcion 0 - Salir");
	}
	
	private void menu() {
		int opcion = 0;
		do {
			mostrarOpciones();
			opcion = input.nextInt();
			input.nextLine();
			switch(opcion) {
				case 1:
					break;
				case 2:
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
		}while(opcion != 0);
	}
	
	public static void main(String[] args) {
		Ejecutora ejecutora = new Ejecutora();
		ejecutora.menu();
		ejecutora.input.close();
	}
}