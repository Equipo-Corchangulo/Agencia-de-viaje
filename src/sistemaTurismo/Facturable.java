package sistemaTurismo;

public interface Facturable {

	 double obtenerCostoTotatl();
	
	 int obtenerTiempoTotal();
	
	 boolean hayCupo();
	
	 void restarCupo();
	
	 TiposDeAtraccion getTipo();
	
}
