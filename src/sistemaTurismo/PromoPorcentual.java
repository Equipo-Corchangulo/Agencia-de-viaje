package sistemaTurismo;


public class PromoPorcentual extends Promocion {
	
	private double porcentajeDescuento;

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
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
