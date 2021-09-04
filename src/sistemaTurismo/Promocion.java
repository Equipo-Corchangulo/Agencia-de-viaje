package sistemaTurismo;

import java.util.List;

public abstract class Promocion  implements Facturable {

	public List<String> listaDeAtracciones; 
	
	public TiposDeAtraccion tipoDePromocion;
	
	public String nombreDePromocion;

	public Promocion(List<String> listaDeAtracciones, TiposDeAtraccion tipoDePromocion, String nombreDePromocion) {
		this.listaDeAtracciones = listaDeAtracciones;
		this.tipoDePromocion = tipoDePromocion;
		this.nombreDePromocion = nombreDePromocion;
	}
}
