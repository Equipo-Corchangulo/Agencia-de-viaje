package sistemaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Recomendador {

	private List<PerfilUsuario> listaDeUsuarios;
	
	private List<Facturable> listaDeAtracciones;
	
	private List<Facturable> listaDePromociones;
	private List<Itinerario> listaDeItinerarios;

	public Recomendador(List<PerfilUsuario> listaDeUsuarios, List<Facturable> listaDeAtracciones,
			List<Facturable> listaDePromociones) {
		super();
		this.listaDeUsuarios = listaDeUsuarios;
		this.listaDeAtracciones = listaDeAtracciones;
		this.listaDePromociones = listaDePromociones;
		this.listaDeItinerarios = new ArrayList<Itinerario>();
	}
	
	public List<Facturable> filtarPorTipo(TipoDeAtraccion tipo, boolean excluir, boolean filtrarPromocion) {
		List<Facturable> listaFiltrada = new ArrayList<Facturable>();
		List<Facturable> listaAFiltrar = filtrarPromocion ? listaDePromociones : listaDeAtracciones;
		
		for (Facturable facturable : listaAFiltrar) {
			if(excluir) {
				if(facturable.getTipo() != tipo) {
					listaFiltrada.add(facturable);
				}
			}else {
				if(facturable.getTipo() == tipo) {
					listaFiltrada.add(facturable);
				}
			}
			
		}
		
		return listaFiltrada;
	}
	
	public boolean leer()
    {
		//si el usuario ingresa 1 es verdadero sino no.
        @SuppressWarnings("resource")
		java.util.Scanner teclado = new java.util.Scanner(System.in);
        
        return teclado.nextInt() == 1;
    }
	
	public void ofrecerSugerencias() {
		
		for(PerfilUsuario usuario : listaDeUsuarios) {
			//decimos a qué usuario estamos recomendandole
			System.out.println("Recomendaciones para usuario : "+ usuario.getNombre());
			System.out.println("Presione 1 para aceptar y 0 para cancelar");
			
			//creamos el itinerario de este usuario
			Itinerario nuevoItinerario = new Itinerario();
			
			//filtramos las atracciones de este usuario dependiendo del tipo que quiera
			List<Facturable> atraccionesRecomendadas = filtarPorTipo(usuario.getTipoDeAtraccion(), false, false);
			List<Facturable> atraccioneNoRecomendadas = filtarPorTipo(usuario.getTipoDeAtraccion(), true, false);
			
			List <Facturable> promocionesRecomendadas = filtarPorTipo(usuario.getTipoDeAtraccion(), false, true);
			//List <Facturable> promocionesNoRecomendadas = filtarPorTipo(usuario.getTipoDeAtraccion(), true, true);

			iterarSugerencias(promocionesRecomendadas, usuario, nuevoItinerario);
			//recorremos las atracciones para ver que le podemos recomendar
			iterarSugerencias(atraccionesRecomendadas, usuario, nuevoItinerario);
			iterarSugerencias(atraccioneNoRecomendadas, usuario, nuevoItinerario);

			listaDeItinerarios.add(nuevoItinerario);
		}
	}
	
	public void iterarSugerencias(List<Facturable> atraccionesAiterar, PerfilUsuario usuario, Itinerario nuevoItinerario) {
		for (Facturable atraccion : atraccionesAiterar) {
			if (!usuario.tieneTiempoYdinero()){
				return;
			}
			//si el usuario tiene dinero y tiempo se lo recomendamos y si la atraccion tiene cupo.
			if(usuario.getPresupuesto() >= atraccion.obtenerCostoTotal()
					&& usuario.getTiempoDisponible() >= atraccion.obtenerTiempoTotal()
					&& atraccion.hayCupo()) {
		
				System.out.println(atraccion);
				
				//si el usuario lo quiere la agregamos al itinerario
				if(leer()) {
					atraccion.restarCupo();
					nuevoItinerario.agregarAtraccion(atraccion);
					usuario.reservarTiempoYdinero(atraccion);
				}
			}
			
		}
	}
}
