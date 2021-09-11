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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDeAtracciones == null) ? 0 : listaDeAtracciones.hashCode());
		result = prime * result + ((nombreDePromocion == null) ? 0 : nombreDePromocion.hashCode());
		result = prime * result + ((tipoDeAtraccion == null) ? 0 : tipoDeAtraccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		if (listaDeAtracciones == null) {
			if (other.listaDeAtracciones != null)
				return false;
		} else if (!listaDeAtracciones.equals(other.listaDeAtracciones))
			return false;
		if (nombreDePromocion == null) {
			if (other.nombreDePromocion != null)
				return false;
		} else if (!nombreDePromocion.equals(other.nombreDePromocion))
			return false;
		if (tipoDeAtraccion != other.tipoDeAtraccion)
			return false;
		return true;
	}

	@Override
	public boolean seEncuentraEnElFacturable(Facturable facturable){
		if (facturable.getClass() == Atraccion.class) {
			for (Facturable atraccion : this.listaDeAtracciones) {
				if (atraccion.equals(facturable))
					return true;
			}
		}
		else{
			if(this.equals(facturable)){
				return true;
			}
			else {
				for (Facturable atraccion : this.listaDeAtracciones) {
					if (facturable.seEncuentraEnElFacturable(atraccion)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
