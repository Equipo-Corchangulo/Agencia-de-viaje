package sistemaTurismo;

public interface Facturable {

	 double obtenerCostoTotal();
	
	 double obtenerTiempoTotal();
	
	 boolean hayCupo();
	
	 void restarCupo();
	
	 TipoDeAtraccion getTipo();
	
}
