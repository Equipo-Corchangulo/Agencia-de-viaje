package sistemaTurismo;

public class PerfilUsuario {

	private double presupuesto;

	private double tiempoDisponible;
	private String nombre;
	private TipoDeAtraccion tipoDeAtraccion;

	public PerfilUsuario(String nombre, double presupuesto, int tiempoDisponible, TipoDeAtraccion tipoDeAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre+ "\nMonedas Disponibles: " + presupuesto + "\nTiempo Disponible:" + tiempoDisponible
				+ "\nTipo de atracción:" + tipoDeAtraccion + " ";
	}

	public double getPresupuesto() {

		return presupuesto;
	}

	public double getTiempoDisponible() {

		return tiempoDisponible;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {

		return tipoDeAtraccion;
	}

	public String getNombre() {

		return nombre;
	}

	public void reservarTiempoYdinero(Facturable atraccion) {
		this.tiempoDisponible -= atraccion.obtenerTiempoTotal();
		this.presupuesto -= atraccion.obtenerCostoTotal();
	}

	public boolean tieneTiempoYdinero() {

		return this.tiempoDisponible > 0 && this.presupuesto > 0 ;
	}

	public boolean puedeComprar(Facturable atraccion) {
		return atraccion.obtenerCostoTotal() <= this.presupuesto 
				&& atraccion.obtenerTiempoTotal() <= this.tiempoDisponible;
	}

}
