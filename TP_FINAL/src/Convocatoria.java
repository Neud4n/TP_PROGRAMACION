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

	public void agregarAspirante() {
		// Completar
	}

	public void seleccionarAspirante() {

		if (this.aspirantes.isEmpty()) {
			System.out.println("No hay aspirantes para seleccionar");
		}

		// 1. Validar que hayan aspirantes.
		// 2. Permitirte elegir un aspirante.
		// 3. Asignarle el puesto al aspirante.
		// 4. Al puesto asignarle el aspirante.
		// 5. A la convocatoria, restarle una vacante.
		// 6. Si la convocatoria, no tiene más vacantes cerrarla.

		if (!this.hayVacantes()) {
			this.cerrarConvocatoria();
		}
	}

	public void mostrarAspirantes() {
		System.out.println("Lista de aspirantes al puesto: ");
		for (Empleado e : aspirantes) {
			System.out.println(e.toString());
			;
		}
	}
}