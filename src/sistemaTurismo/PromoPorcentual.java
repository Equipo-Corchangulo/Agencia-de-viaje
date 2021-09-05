package sistemaTurismo;


import java.util.List;

public class PromoPorcentual extends Promocion {
	
	private double porcentajeDescuento;

	public PromoPorcentual(List<Facturable> listaDeAtracciones, TiposDeAtraccion tipoDePromocion
			, String nombreDePromocion, double porcentajeDescuento) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	@Override
	public double obtenerCostoTotal() {
		double costoTotal = 0;
		for (Facturable atraccion : listaDeAtracciones) {
			costoTotal += atraccion.obtenerCostoTotal();
		}
		costoTotal -= costoTotal * porcentajeDescuento;
		return costoTotal;
	}

	@Override
	public double obtenerTiempoTotal() {
		double tiempoTotal = 0;
		for (Facturable atraccion : listaDeAtracciones) {
			tiempoTotal += atraccion.obtenerTiempoTotal();
		}
		return tiempoTotal;
	}

	@Override
	public boolean hayCupo() {
			for (Facturable atraccion : listaDeAtracciones) {
				if (!atraccion.hayCupo())
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
	public TiposDeAtraccion getTipo() {
		
		 return this.tipoDeAtraccion;
		
	}
	
}
