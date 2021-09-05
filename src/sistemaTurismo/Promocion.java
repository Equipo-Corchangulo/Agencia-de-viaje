package sistemaTurismo;

import java.util.List;

public abstract class Promocion  implements Facturable {
	public enum enumDePromocion {
		ABSOLUTA,
		AXB,
		PORCENTUAL;
	}

	public List<Facturable> listaDeAtracciones;
	
	public TiposDeAtraccion tipoDeAtraccion;
	
	public String nombreDePromocion;

	public Promocion(List<Facturable> listaDeAtracciones, TiposDeAtraccion tipoDeAtraccion, String nombreDePromocion) {
		this.listaDeAtracciones = listaDeAtracciones;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.nombreDePromocion = nombreDePromocion;
	}

	@Override
	public String toString() {
		return "promocion: "+ this.nombreDePromocion
				+ " del tipo: " + this.getTipo()
				+ " costo: " + this.obtenerCostoTotal()
				+ " Tiempo requerido: " + this.obtenerTiempoTotal();
	}
}
