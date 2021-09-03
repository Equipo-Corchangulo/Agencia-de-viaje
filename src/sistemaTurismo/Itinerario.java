package sistemaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {

	private float horasNecesarias;
	private double costoMonedas;
	private List<Facturable> ListaDeVisitas = new ArrayList<Facturable>();

	public float getHorasNecesarias() {
		return horasNecesarias;
	}

	public double getCostoMonedas() {
		return costoMonedas;
	}
	
	public List<Facturable> getListaDeVisitas() {
		
		return this.ListaDeVisitas;
	}
	public void agregarAtraccion(Facturable atraccion) {
		this.ListaDeVisitas.add(atraccion);
	}
	
	
}
