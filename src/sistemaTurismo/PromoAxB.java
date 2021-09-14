package sistemaTurismo;

import java.util.List;

public class PromoAxB extends Promocion {

	public Facturable atraccionExtra;

	public PromoAxB(List<Facturable> listaDeAtracciones, TipoDeAtraccion tipoDePromocion
			, String nombreDePromocion, Facturable atraccionExtra) {
		super(listaDeAtracciones, tipoDePromocion, nombreDePromocion);
		this.atraccionExtra = atraccionExtra;
	}

	@Override
	public double obtenerTiempoTotal() {
		double tiempoTotal = super.obtenerTiempoTotal();
		tiempoTotal += atraccionExtra.obtenerTiempoTotal();
		return tiempoTotal;
	}

	@Override
	public boolean hayCupo() {
		boolean hayCupo = super.hayCupo();
		return hayCupo && atraccionExtra.hayCupo();
	}

	@Override
	public void restarCupo() {
		super.restarCupo();
		atraccionExtra.restarCupo();
	}

	@Override
	public boolean seEncuentraEnElFacturable(Facturable facturable) {

		return super.seEncuentraEnElFacturable(facturable) || this.atraccionExtra.seEncuentraEnElFacturable(facturable);
	}

	@Override
	public String toString() {
		return super.toString() +" Atraccion de regalo: \n" + atraccionExtra;
	}

}
