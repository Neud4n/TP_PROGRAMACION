
public class Conocimiento {
	private String descripcion;

	public Conocimiento(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public boolean comparoDescripcion(String descripcion) {
		return this.descripcion.equals(descripcion);
	}

	public void imprimirDatos() {
		System.out.println("Habilidad: " + this.descripcion);
	}

}
