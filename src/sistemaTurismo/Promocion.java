package sistemaTurismo;

import java.util.List;

public abstract class Promocion  implements Facturable {
	public enum enumDePromocion {
		ABSOLUTA,
		AXB,
		PORCENTUAL;
	}

	public List<Facturable> listaDeAtracciones;

	public TipoDeAtraccion tipoDeAtraccion;

	public String nombreDePromocion;

	public Promocion(List<Facturable> listaDeAtracciones, TipoDeAtraccion tipoDeAtraccion, String nombreDePromocion) {
		this.listaDeAtracciones = listaDeAtracciones;
		this.tipoDeAtraccion = tipoDeAtraccion;
		this.nombreDePromocion = nombreDePromocion;
	}

	@Override
	public String toString() {
		return "promocion: "+ this.nombreDePromocion
				+ " del tipo: " + this.getTipo()
				+ " costo: " + this.obtenerCostoTotal()
				+ " Tiempo requerido: " + this.obtenerTiempoTotal();
	}
	@Override
	public  boolean esPromocion(){
		return  true;
	}

	@Override
	public int compareTo(Facturable o) {
		return o.esPromocion() ? 0 : 1;
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
	public double obtenerTiempoTotal() {
		double tiempoTotal = 0;
		for(Facturable atraccion : listaDeAtracciones){
			tiempoTotal+= atraccion.obtenerTiempoTotal();
		}
		return tiempoTotal;

	}
	@Override
	public TipoDeAtraccion getTipo() {

		return this.tipoDeAtraccion;

	}

	@Override
	public double obtenerCostoTotal() {
		double costoTotal = 0;
		for (Facturable atraccion : listaDeAtracciones) {
			costoTotal += atraccion.obtenerCostoTotal();
		}
		return costoTotal;
	}

}
