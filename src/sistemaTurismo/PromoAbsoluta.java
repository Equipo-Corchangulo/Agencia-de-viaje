package sistemaTurismo;

import java.util.List;

public class PromoAbsoluta extends Promocion {

	private double costoFijo;

	public PromoAbsoluta(List<String> listaDeAtracciones, TiposDeAtraccion tipoDePromocion, String nombreDePromocion, double costoFijo) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.costoFijo = costoFijo;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	@Override
	public double obtenerCostoTotatl() {
		return costoFijo;
	}

	@Override
	public int obtenerTiempoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void restarCupo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TiposDeAtraccion getTipo() {
		
		return this.tipoDePromocion;	
	}
}
