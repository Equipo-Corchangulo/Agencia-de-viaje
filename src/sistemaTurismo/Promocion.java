package sistemaTurismo;

public abstract class Promocion  implements Facturable {

	public String[] listaDeAtracciones; 
	
	public enum tipoDePromocion {
		AVENTURA,
		DEGUSTACION,
		PAISAJE;
	}
	
	public String nombreDePromocion;
	
}
