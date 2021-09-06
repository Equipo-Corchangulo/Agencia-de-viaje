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
	public double obtenerTiempoTotal() {
		double tiempoTotal = 0;
		for(Facturable atraccion : listaDeAtracciones){
			tiempoTotal+= atraccion.obtenerTiempoTotal();
		}
		return tiempoTotal;
	}

	@Override
	public boolean hayCupo() {
		for(Facturable atraccion : listaDeAtracciones){
			if(!atraccion.hayCupo())
				return false;
		}
		return true;
	}

	@Override
	public void restarCupo() {
		for(Facturable atraccion : listaDeAtracciones){
			atraccion.restarCupo();
		}
		
	}

	@Override
	public TipoDeAtraccion getTipo() {
		
		return this.tipoDeAtraccion;
	}
}
