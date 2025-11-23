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

	public void seleccionarAspirante(Empleado e) {

		if (this.aspirantes.isEmpty()) {
			System.out.println("No hay aspirantes para seleccionar");
			return;
		}

		if (!this.aspirantes.contains(e)) {
			System.out.println("El aspirante no esta inscrito");
			return;
		}

		if (e.sosJerarquico() && !this.puestoConvotaria.sosJerarquico()) {
			e = new EmpleadoNoJerarquico(e.getDni(), e.getNombre(), e.getApellido(), e.getAntiguedad(), e.getSkills());
		}

		if (!e.sosJerarquico() && this.puestoConvotaria.sosJerarquico()) {
			e = new EmpleadoJerarquico(e.getDni(), e.getNombre(), e.getApellido(), e.getSkills(), e.getAntiguedad());
		}

		this.puestoConvotaria.tomarEmpleado(e);

		this.vacantes--;

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