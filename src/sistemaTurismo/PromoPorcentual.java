package sistemaTurismo;

import java.util.List;

public class PromoPorcentual extends Promocion {

	private double porcentajeDescuento;

	public PromoPorcentual(List<Facturable> listaDeAtracciones, TipoDeAtraccion tipoDePromocion
			, String nombreDePromocion, double porcentajeDescuento) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	@Override
	public double obtenerCostoTotal() {
		double costoTotal = super.obtenerCostoTotal();
		costoTotal -= costoTotal * porcentajeDescuento;
		return costoTotal;
	}

	@Override
	public String toString() {
		
		return super.toString() + "El porcentaje de descuento es de: " + (porcentajeDescuento*100) + "%";
	}
	
}
