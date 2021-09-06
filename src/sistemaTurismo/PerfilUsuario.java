package sistemaTurismo;

public class PerfilUsuario {

	private double presupuesto;

	private double tiempoDisponible;
	private String nombre;
	private TipoDeAtraccion tipoDeAtraccion;
	
	public PerfilUsuario(double presupuesto, int tiempoDisponible, TipoDeAtraccion tipoDeAtraccion, String nombre) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "PerfilUsuario [presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoDeAtraccion=" + tipoDeAtraccion + "]";
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
}