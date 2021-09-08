package sistemaTurismo;

import java.util.List;

public class PromoAxB extends Promocion {

	public Facturable atracionExtra;

	public PromoAxB(List<Facturable> listaDeAtracciones, TipoDeAtraccion tipoDePromocion
			, String nombreDePromocion, Facturable atracionExtra) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.atracionExtra = atracionExtra;
	}

	@Override
	public double obtenerTiempoTotal() {
		double tiempoTotal = super.obtenerTiempoTotal();
		tiempoTotal += atracionExtra.obtenerTiempoTotal();
		return tiempoTotal;
	}

	@Override
	public boolean hayCupo() {
		boolean hayCupo = super.hayCupo();
		return hayCupo && atracionExtra.hayCupo();
	}

	@Override
	public void restarCupo() {
		super.restarCupo();
		atracionExtra.restarCupo();
	}
}
