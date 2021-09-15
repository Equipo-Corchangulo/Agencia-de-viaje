package sistemaTurismo;

import java.util.ArrayList;
import java.util.Collections;
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
		atraccion.restarCupo();
		this.usuario.reservarTiempoYdinero(atraccion);
	}
	 
	public boolean poseeAtraccion(Facturable atraccion) {
		for(Facturable visitas: this.ListaDeVisitas){
			if(visitas.seEncuentraEnElFacturable(atraccion)){
				return true;
			}
		}
		return false;
	}
	public PerfilUsuario getUsuario(){
		return this.usuario;
	}
	
	public boolean puedeComprar(Facturable atraccion) {
		return  !this.poseeAtraccion(atraccion) && usuario.puedeComprar(atraccion) && atraccion.hayCupo();
	}

	@Override
	public String toString() {
		String salida = "Itinerario: " +
				"usuario = " + usuario.getNombre() +
				", horasNecesarias = " + horasNecesarias +
				", costoMonedas = " + costoMonedas +
				"\nListaDeVisitas = \n";
		for (Facturable facturable : ListaDeVisitas) {
			salida += facturable.toString();
		}
		return salida;
	}
}
