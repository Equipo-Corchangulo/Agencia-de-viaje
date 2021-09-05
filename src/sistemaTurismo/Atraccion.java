package sistemaTurismo;

public class Atraccion implements Facturable {

	private double costoVisita;
	private double tiempoPromedio;
	private int cupoDiario;
	private String nombre;
	private TiposDeAtraccion tipoAtraccion;
	
	public Atraccion(double costoVisita, double tiempoPromedio, int cupoDiario, TiposDeAtraccion tipoAtraccion, String nombre) {
		super();
		this.costoVisita = costoVisita;
		this.tiempoPromedio = tiempoPromedio;
		this.cupoDiario = cupoDiario;
		this.tipoAtraccion = tipoAtraccion;
		this.nombre = nombre;
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
	public TiposDeAtraccion getTipo() {
	
		return this.tipoAtraccion;
		
	}


	
}
