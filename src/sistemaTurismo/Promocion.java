package sistemaTurismo;

import java.util.List;

public abstract class Promocion  implements Facturable {

	public List<Facturable> listaDeAtracciones;
	
	public TiposDeAtraccion tipoDePromocion;
	
	public String nombreDePromocion;

	public Promocion(List<Facturable> listaDeAtracciones, TiposDeAtraccion tipoDePromocion, String nombreDePromocion) {
		this.listaDeAtracciones = listaDeAtracciones;
		this.tipoDePromocion = tipoDePromocion;
		this.nombreDePromocion = nombreDePromocion;
	}

	@Override
	public String toString() {
		return "promocion: "+ this.nombreDePromocion
				+ " del tipo: " + this.getTipo()
				+ " costo: " + this.obtenerCostoTotatl()
				+ " Tiempo requerido: " + this.obtenerTiempoTotal();
	}
}
