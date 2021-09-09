package sistemaTurismo;

public class Atraccion implements Facturable {

	private double costoVisita;
	private double tiempoPromedio;
	private int cupoDiario;
	private String nombre;
	private TipoDeAtraccion tipoAtraccion;

	public Atraccion(String nombre, double costoVisita, double tiempoPromedio, int cupoDiario, TipoDeAtraccion tipoAtraccion) {
		super();
		this.nombre = nombre;
		this.costoVisita = costoVisita;
		this.tiempoPromedio = tiempoPromedio;
		this.cupoDiario = cupoDiario;
		this.tipoAtraccion = tipoAtraccion;
	}

	@Override
	public String toString() {
		return "Atraccion : " + nombre + ", tiempo promedio : " + tiempoPromedio + ", costo : " + costoVisita +
				", tipo de atraccion : " + tipoAtraccion; 

	}

	@Override
	public double obtenerCostoTotal() {

		return this.costoVisita;
	}

	@Override
	public double obtenerTiempoTotal() {

		return  this.tiempoPromedio;
	}

	@Override
	public boolean hayCupo() {

		return this.cupoDiario > 0;
	}

	@Override
	public void restarCupo() {
		this.cupoDiario--;

	}

	public int getCupo() {
		return this.cupoDiario;
	}
	@Override
	public TipoDeAtraccion getTipo() {

		return this.tipoAtraccion;

	}

	@Override
	public int compareTo(Facturable o) {
		return o.esPromocion() ? -1 : 0;
	}

	@Override
	public  boolean esPromocion(){
		return false;
	}

}
