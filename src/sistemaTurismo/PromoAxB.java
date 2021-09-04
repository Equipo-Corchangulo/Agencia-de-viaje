package sistemaTurismo;

import java.util.List;

public class PromoAxB extends Promocion {

	public String atracionExtra;

	public PromoAxB(List<String> listaDeAtracciones, PromocionType tipoDePromocion, String nombreDePromocion, String atracionExtra) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.atracionExtra = atracionExtra;
	}

	public String getAtracionExtra() {
		return atracionExtra;
	}

	public void setAtracionExtra(String atracionExtra) {
		this.atracionExtra = atracionExtra;
	}

	@Override
	public double obtenerCostoTotatl() {
		// TODO Auto-generated method stub
		return 0;
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
	public PromocionType getTipo() {
		
		return this.tipoDePromocion;
	}
}
