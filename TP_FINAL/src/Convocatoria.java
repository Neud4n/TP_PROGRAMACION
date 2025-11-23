import java.util.ArrayList;
import java.time.LocalDate;

public class Convocatoria {
	private static int contador = 0;
	private final int ID;
	private int vacantes;
	private boolean estadoConvocatoria;
	private LocalDate inicioConvotaria;
	private LocalDate finConvocatoria;
	private Puesto puestoConvotaria;
	private ArrayList<Empleado> aspirantes;

	public Convocatoria(int vacantes, LocalDate inicio, Puesto puestoConvocatoria) {
		this.ID = ++contador;
		this.vacantes = vacantes;
		this.estadoConvocatoria = true;
		this.inicioConvotaria = inicio;
		this.finConvocatoria = null;
		this.puestoConvotaria = puestoConvocatoria;
		this.aspirantes = new ArrayList<>();
	}

	public boolean comparoId(int id) {
		return this.ID == id;
	}

	public boolean getEstado() {
		return this.estadoConvocatoria;
	}

	private boolean hayVacantes() {
		return this.vacantes > 0;
	}

	private void cerrarConvocatoria() {
		this.estadoConvocatoria = false;
		this.finConvocatoria = LocalDate.now();
	}

	public void agregarAspirante(Empleado e) {

		if (!this.hayVacantes()) {
			System.out.println("No hay vacantes para agregar aspirantes");
			return;
		}

		if (this.aspirantes.contains(e)) {
			System.out.println("El aspirante ya esta inscrito");
			return;
		}

		if (!this.puestoConvotaria.cumpleRequisitos(e)) {
			System.out.println("El aspirante no cumple con los requisitos del puesto");
			return;
		}

		this.aspirantes.add(e);
	}

	public void seleccionarAspirante() {

		if (this.aspirantes.isEmpty()) {
			System.out.println("No hay aspirantes para seleccionar");
			return;
		}

		// Si el empleado es Jerarquico y el puesto no, deberíamos convertir el empleado
		// en NoJerarquico.
		// Si el empleado es NoJerarquico y el puesto es Jerarquico, deberíamos
		// convertir
		// el empleado en Jerarquico.

		// 1. Validar que hayan aspirantes. -- Hecho.
		// 2. Permitirte elegir un aspirante.
		// 3. Asignarle el puesto al aspirante.
		// 4. Al puesto asignarle el aspirante.
		// 5. A la convocatoria, restarle una vacante.
		// 6. Si la convocatoria, no tiene más vacantes cerrarla.

		this.vacantes--; // Reducimos la cantidad de vacantes cuando se selecciona un aspirante.

		if (!this.hayVacantes()) {
			this.cerrarConvocatoria();
		}
	}

	public void mostrarAspirantes() {
		System.out.println("Lista de aspirantes al puesto: ");
		for (Empleado e : aspirantes) {
			System.out.println(e.toString());
		}
	}

	public void imprimirDatos() {
		System.out.println("========================================");
		System.out.println("       DETALLES DE LA CONVOCATORIA      ");
		System.out.println("========================================");
		System.out.println(" ID                  : " + this.ID);
		System.out.println(" Puesto              : " + this.puestoConvotaria.getDescripcion());
		System.out.println(" Vacantes Disponibles: " + this.vacantes);
		System.out.println(" Estado              : " + (this.estadoConvocatoria ? "ABIERTA" : "CERRADA"));
		System.out.println("----------------------------------------");
		System.out.println(" Fecha Inicio        : " + this.inicioConvotaria);
		System.out.println(
				" Fecha Fin           : " + (this.finConvocatoria != null ? this.finConvocatoria : "En curso"));
		System.out.println("----------------------------------------");
		System.out.println(" Cant. Aspirantes    : " + this.aspirantes.size());
		System.out.println("========================================");
	}
}