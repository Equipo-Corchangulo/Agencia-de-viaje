package sistemaTurismo;

public interface Facturable extends Comparable<Facturable> {

	 double obtenerCostoTotal();

	 double obtenerTiempoTotal();

	 boolean hayCupo();

	 void restarCupo();

	 boolean esPromocion();

	 TipoDeAtraccion getTipo();

}
