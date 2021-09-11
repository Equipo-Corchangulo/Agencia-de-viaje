package sistemaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
	
	private PerfilUsuario usuario;
	private double horasNecesarias;
	private double costoMonedas;
	private List<Facturable> ListaDeVisitas = new ArrayList<Facturable>();
	
	public Itinerario(PerfilUsuario usuario) {
		super();
		this.usuario = usuario;
	}

	public double getHorasNecesarias() {
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
		horasNecesarias += atraccion.obtenerTiempoTotal();
		costoMonedas += atraccion.obtenerCostoTotal();
	}
	 
	public boolean poseeAtraccion(Facturable atraccion) {
		for(Facturable visitas: this.ListaDeVisitas){
			if(visitas.seEncuentraEnElFacturable(atraccion)){
				return true;
			}
		}
		return false;
	}

}
