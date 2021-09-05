package sistemaTurismo;

public interface Facturable {

	 double obtenerCostoTotal();
	
	 double obtenerTiempoTotal();
	
	 boolean hayCupo();
	
	 void restarCupo();
	
	 TiposDeAtraccion getTipo();
	
}
