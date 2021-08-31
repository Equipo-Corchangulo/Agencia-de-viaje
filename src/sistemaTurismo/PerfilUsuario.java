package sistemaTurismo;

public class PerfilUsuario {


	private double presupuesto;

	private int tiempoDisponible;

	private PromocionType tipoDeAtraccion;

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(int tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public PromocionType getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public void setTipoDeAtraccion(PromocionType tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
}
