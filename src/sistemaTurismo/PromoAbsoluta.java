package sistemaTurismo;

import java.util.List;

public class PromoAbsoluta extends Promocion {

	private double costoFijo;

	public PromoAbsoluta(List<Facturable> listaDeAtracciones, TipoDeAtraccion tipoDePromocion, String nombreDePromocion, double costoFijo) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.costoFijo = costoFijo;
	}

	@Override
	public double obtenerCostoTotal() {
		return costoFijo;
	}

	@Override
	public String toString() {
		return super.toString() + " Todo al precio de: " + costoFijo + "\n";
	}

	
}
