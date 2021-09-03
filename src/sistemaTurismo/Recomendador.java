package sistemaTurismo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recomendador {

	private List<PerfilUsuario> listaDeUsuarios;
	
	private List<Atraccion> listaDeAtracciones;
	
	private List<Promocion> listaDePromociones;
	private List<Itinerario> listaDeItinerarios;

	public Recomendador(List<PerfilUsuario> listaDeUsuarios, List<Atraccion> listaDeAtracciones,
			List<Promocion> listaDePromociones) {
		super();
		this.listaDeUsuarios = listaDeUsuarios;
		this.listaDeAtracciones = listaDeAtracciones;
		this.listaDePromociones = listaDePromociones;
		this.listaDeItinerarios = new ArrayList<Itinerario>();
	}
	
	public List<Facturable> filtarPorTipo(PromocionType tipo) {
		List<Facturable> listaFiltrada = new ArrayList<Facturable>();
		for (Facturable facturable : listaDeAtracciones) {
			if(facturable.getTipo() == tipo) {
				listaFiltrada.add(facturable);
			}
		}
		
		return listaFiltrada;
	}
	
	public boolean leer()
    {
		//si el usuario ingresa 1 es verdadero sino no.
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        
        return teclado.nextInt() == 1;
    }
	
	public void ofrecerSugerencias() {
		
		for(PerfilUsuario usuario : listaDeUsuarios) {
			//decimos a que usuario estamos recomendandole
			System.out.println("Recomendaciones para usuario : "+ usuario.getNombre());
			
			//creamos el itinerario de este usuario
			Itinerario nuevoItinerario = new Itinerario();
			
			//filtramos las atracciones de este usuario dependiendo del tipo que quiera
			List<Facturable> atraccionesRecomendadas = filtarPorTipo(usuario.getTipoDeAtraccion());
			
			//recorremos las atracciones para ver que le podemos recomendar
			for (Facturable atraccion : atraccionesRecomendadas) {
				
				//si el usuario tiene dinero y tiempo se lo recomendamos y si la atraccion tiene cupo.
				if(usuario.getPresupuesto() >= atraccion.obtenerCostoTotatl() 
						&& usuario.getTiempoDisponible() >= atraccion.obtenerTiempoTotal()
						&& atraccion.hayCupo()) {
					System.out.println("Precione 1 para aceptar y 0 para cancelar");
					System.out.println(atraccion);
					
					//si el usuario lo quiere la agregamos al itinerario
					if(leer()) {
						atraccion.restarCupo();
						nuevoItinerario.agregarAtraccion(atraccion);
					}
				}
				
			}
			
			listaDeItinerarios.add(nuevoItinerario);
		}
	}
}
