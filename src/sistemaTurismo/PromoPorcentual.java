package sistemaTurismo;


import java.util.List;

public class PromoPorcentual extends Promocion {
	
	private double porcentajeDescuento;

	public PromoPorcentual(List<String> listaDeAtracciones, PromocionType tipoDePromocion, String nombreDePromocion, double porcentajeDescuento) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
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
