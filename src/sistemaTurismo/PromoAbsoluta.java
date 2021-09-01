package sistemaTurismo;

public class PromoAbsoluta extends Promocion {

	private double costoFijo;

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
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
