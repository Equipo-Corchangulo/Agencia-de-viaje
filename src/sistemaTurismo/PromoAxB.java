package sistemaTurismo;

import java.util.List;

public class PromoAxB extends Promocion {

	public Facturable atracionExtra;

	public PromoAxB(List<Facturable> listaDeAtracciones, TiposDeAtraccion tipoDePromocion
			, String nombreDePromocion, Facturable atracionExtra) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.atracionExtra = atracionExtra;
	}

	@Override
	public double obtenerCostoTotal() {
		double costoTotal = 0;
		for (Facturable atraccion : listaDeAtracciones) {
			costoTotal += atraccion.obtenerCostoTotal();
		}
		return costoTotal;
	}

	@Override
	public double obtenerTiempoTotal() {
		double tiempoTotal = 0;
		for (Facturable atraccion : listaDeAtracciones) {
			tiempoTotal += atraccion.obtenerTiempoTotal();
		}
		tiempoTotal += atracionExtra.obtenerTiempoTotal();
		return tiempoTotal;
	}

	@Override
	public boolean hayCupo() {
		for (Facturable atraccion : listaDeAtracciones) {
			if(!atraccion.hayCupo()){
				return false;
			}
		}
		return atracionExtra.hayCupo();
	}

	@Override
	public void restarCupo() {
		for (Facturable atraccion : listaDeAtracciones) {
			atraccion.restarCupo();
		}
		atracionExtra.restarCupo();
	}

	@Override
	public TiposDeAtraccion getTipo() {
		return this.tipoDeAtraccion;
	}
}
