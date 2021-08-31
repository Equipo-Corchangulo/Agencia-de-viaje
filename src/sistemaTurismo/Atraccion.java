package sistemaTurismo;

public class Atraccion implements Facturable {

	private double costoVisita;

	public int getCupoDiario() {
		return cupoDiario;
	}

	public void setCupoDiario(int cupoDiario) {
		this.cupoDiario = cupoDiario;
	}

	public PromocionType getTipoAtraccion() {
		return tipoAtraccion;
	}

	public void setTipoAtraccion(PromocionType tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	private int TiempoPromedio;

	private int cupoDiario;

	private PromocionType tipoAtraccion;

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
	public void getTipo() {
		// TODO Auto-generated method stub
		
	}
	
}
